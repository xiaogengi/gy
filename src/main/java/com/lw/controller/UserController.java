package com.lw.controller;


import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.User;
import com.lw.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;


    /**
     * 创建用户
     * @return
     */
    @RequestMapping("save")
    public int save(User param){
        return userServer.saveUser(param);
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("queryAllUser")
    public JSONObject queryAllUser(){
        return userServer.queryAllUser();
    }

    /**
     *  删除 用户 信息
     */
    @RequestMapping("deleteOrderById")
    public int deleteOrderById(Integer id){
        return userServer.deleteUserById(id);
    }

    /**
     *  更新用户类型
     */
    @RequestMapping("updateUserRoot")
    public int updateUserRoot(Integer id, Integer type){
        return userServer.updateUserRoot(id,type);
    }

    /**
     * 打开 user 主页面
     */
    @RequestMapping("userList")
    public ModelAndView orderList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userList");
        return modelAndView;
    }


}
