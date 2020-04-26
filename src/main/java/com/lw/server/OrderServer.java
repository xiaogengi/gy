package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Order;

import java.util.List;

public interface OrderServer{

    int saveOrder(Order param);

    JSONObject queryAllOrder();
}
