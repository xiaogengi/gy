package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.OrderMapper;
import com.lw.pojo.Order;
import com.lw.pojo.dto.OrderDTO;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.OrderServer;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServerImpl implements OrderServer {

    static SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int saveOrder(Order param, HttpServletRequest request) {
        try {
            if(!checkDate(param.getGyDate())){
                return 400;
            }
            param.setUserId(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
            return orderMapper.saveOrder(param);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    boolean checkDate(String date) throws Exception{
        Date th = new Date();
        Date parse = sim.parse(sim.format(th));
        Date parse1 = sim.parse(date);
        if(parse.getTime() <= parse1.getTime()){
            return true;
        }
        return false;
    }

    @Override
    public JSONObject queryAllOrder(HttpServletRequest request, OrderDTO orderDTO) {
        try {
            checkDto(orderDTO);
            System.err.println(orderDTO);
            String type = request.getSession().getAttribute("userType").toString();
            List<Order> orders = null;
            if("1".equals(type) || type.equals(1)){
                orders = orderMapper.queryAllOrder(orderDTO);
                for (int i = 0; i < orders.size(); i++) {
                    orders.get(i).setType(1);
                }
            }else{
                String userId = request.getSession().getAttribute("userId").toString();
                orders = orderMapper.queryAllOrderById(userId,orderDTO);
            }
            //时间条件查询
            if(orderDTO != null && (checkStr(orderDTO.getStartTime()) || checkStr(orderDTO.getEndTime()))){
                List<Order> objects = new ArrayList<>();
                for (Order order : orders) {
                    if(timeFilter(order.getStartTime(), orderDTO.getStartTime(), order.getEndTime(), orderDTO.getEndTime())){
                        objects.add(order);
                    }
                }
                orders = objects;
            }

            return JSONObjectUtil.jsonUtil(orders);
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
        }
    }

    private static void checkDto(OrderDTO orderDTO) {
        if(orderDTO == null){
            return;
        }
        if(orderDTO.getUserName() == ""){
            orderDTO.setUserName(null);
        }
        if(orderDTO.getGyDate() == ""){
            orderDTO.setGyDate(null);
        }
        if(orderDTO.getFieidName() == ""){
            orderDTO.setFieidName(null);
        }
    }

    private static boolean checkStr(String param){
        try {
            if(param != null && param != ""){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




    @Override
    public int deleteOrderById(Integer id) {
        try {
            return orderMapper.deleteOrderById(id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ModelAndView queryOrderById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("order",orderMapper.queryOrderById(id));
            modelAndView.setViewName("/order/editOrder");
            return modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.setViewName("/error/error");
            return modelAndView;
        }
    }

    @Override
    public int updateOrder(Order param) {
        try {
            if(!checkDate(param.getGyDate())){
                return 400;
            }
            return orderMapper.updateOrder(param);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    private static String TIME = "2001-01-01 ";
    private static SimpleDateFormat SIM_DATA_TIME = new SimpleDateFormat("YYYY-MM-dd HH:mm");


    public static void main(String[] args) {

    }

    // 名称 || 用户名 || 日期 筛选
    public static boolean strFilter(String str, String strParam){
        try {
            if(strParam != null && strParam != ""){
                if(str.equals(strParam)){
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 时间筛选
    public static boolean timeFilter(String startTime, String startParam, String endTime, String endParam){
        try {
            if(startParam != null && startParam != "" && endParam != null && endParam != ""){
                return checkTime(startTime, startParam, endTime, endParam);
            }else if(startParam != null && startParam != ""){
                return checkTime(startTime,startParam, "start");
            }else if(endParam != null && endParam != ""){
                return checkTime(endTime, endParam, "end");
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // 12:00 ~ 15:00
    public static boolean checkTime(String startTime, String startParam, String endTime, String endParam){
        try {
            startTime = TIME+startTime;
            startParam = TIME+startParam;
            endTime = TIME+endTime;
            endParam = TIME+endParam;
            long startL = SIM_DATA_TIME.parse(startTime).getTime();
            long startParamL = SIM_DATA_TIME.parse(startParam).getTime();
            long endL = SIM_DATA_TIME.parse(endTime).getTime();
            long endParamL = SIM_DATA_TIME.parse(endParam).getTime();
            if(startL >= startParamL && endL <= endParamL){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // 只有 开始时间 或者  只有结束时间
    public static boolean checkTime(String startTime, String startParam,String key){
        try {
            startTime = TIME+startTime;
            startParam = TIME+startParam;
            long startL = SIM_DATA_TIME.parse(startTime).getTime();
            long startParamL = SIM_DATA_TIME.parse(startParam).getTime();
            if(key.equals("start")){
                if(startL >= startParamL){
                    return true;
                }
            }else{
                if(startL <= startParamL){
                    return true;
                }
            }

            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }





}
