package com.lw.server;

import com.lw.pojo.Order;

import java.util.List;

public interface OrderServer{

    int saveOrder(Order param);

    List<Order> queryAllOrder();
}
