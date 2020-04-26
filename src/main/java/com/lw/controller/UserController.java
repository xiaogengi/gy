package com.lw.controller;


import com.lw.pojo.User;
import com.lw.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> queryAllUser(){
        return userServer.queryAllUser();
    }




}
