package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Order;
import com.lw.pojo.User;
import com.lw.server.FieidServer;
import com.lw.server.OrderServer;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private OrderServer orderServer;


    /**
     * 创建预约订单
     * @return
     */
    @RequestMapping("saveOrder")
    public int save(Order param, HttpServletRequest request){
        return orderServer.saveOrder(param,request);
    }

    /**
     * 查询所有预约订单
     * @return
     */
    @RequestMapping("queryAllOrder")
    public JSONObject queryAllOrder(HttpServletRequest request){
        return orderServer.queryAllOrder(request);
    }


    /**
     *  删除预约信息
     */
    @RequestMapping("deleteOrderById")
    public int deleteOrderById(Integer id){
        return orderServer.deleteOrderById(id);
    }


    /**
     * 回显预约信息
     */
    @RequestMapping("queryOrderById")
    public ModelAndView queryOrderById(Integer id){
        return orderServer.queryOrderById(id);
    }

    /**
     * 修改预约信息
     */
    @RequestMapping("updateOrder")
    public int updateOrder(Order param){
        return orderServer.updateOrder(param);
    }

    /**
     * 打开 order 主页面
     */
    @RequestMapping("orderList")
    public ModelAndView orderList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/order/orderList");
        return modelAndView;
    }



}
