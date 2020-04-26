package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.OrderMapper;
import com.lw.pojo.Order;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.OrderServer;
import com.lw.utils.JSONObjectUtil;
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
    public JSONObject queryAllOrder() {
        try {
            List<Order> orders = orderMapper.queryAllOrder();
            return JSONObjectUtil.jsonUtil(orders);
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
        }
    }
}
