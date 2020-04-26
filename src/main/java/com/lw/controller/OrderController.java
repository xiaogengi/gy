package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Order;
import com.lw.pojo.User;
import com.lw.server.FieidServer;
import com.lw.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public int save(Order param){
        return orderServer.saveOrder(param);
    }

    /**
     * 查询所有预约订单
     * @return
     */
    @RequestMapping("queryAllOrder")
    public JSONObject queryAllOrder(){
        return orderServer.queryAllOrder();
    }




    /**
     *  删除预约信息
     */
    @RequestMapping("deleteOrderById")
    public int deleteOrderById(Integer id){
        return orderServer.deleteOrderById(id);
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
