package com.lw.controller;

import com.lw.pojo.Order;
import com.lw.pojo.User;
import com.lw.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Order> queryAllOrder(){
        return orderServer.queryAllOrder();
    }




}
