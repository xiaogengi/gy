package com.lw.server.impl;


import com.lw.mapper.OrderMapper;
import com.lw.pojo.Order;
import com.lw.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServerImpl implements OrderServer {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int saveOrder(Order param) {
        try {
            return orderMapper.saveOrder(param);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> queryAllOrder() {
        try {
            return orderMapper.queryAllOrder();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
