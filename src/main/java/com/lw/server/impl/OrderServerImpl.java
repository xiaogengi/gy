package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.OrderMapper;
import com.lw.pojo.Order;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.OrderServer;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
    public JSONObject queryAllOrder(HttpServletRequest request) {
        try {
            String type = request.getSession().getAttribute("userType").toString();
            List<Order> orders = null;
            if("1".equals(type) || type.equals(1)){
                orders = orderMapper.queryAllOrder();
                for (int i = 0; i < orders.size(); i++) {
                    orders.get(i).setType(1);
                }
            }else{
                String userId = request.getSession().getAttribute("userId").toString();
                orders = orderMapper.queryAllOrderById(userId);
            }
            return JSONObjectUtil.jsonUtil(orders);
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
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


}
