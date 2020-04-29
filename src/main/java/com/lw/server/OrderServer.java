package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Order;
import com.lw.pojo.dto.OrderDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface OrderServer{

    int saveOrder(Order param, HttpServletRequest request);

    JSONObject queryAllOrder(HttpServletRequest request, OrderDTO orderDTO);

    int deleteOrderById(Integer id);

    ModelAndView queryOrderById(Integer id);

    int updateOrder(Order param);
}
