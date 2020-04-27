package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.dto.RegisterDTO;
import com.lw.server.RegisterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("register")
@RestController
public class RegisterController {

    @Autowired
    private RegisterServer registerServer;

    @RequestMapping("/")
    public ModelAndView register(){
        return new ModelAndView("/register/register");
    }

    @RequestMapping("register")
    public JSONObject registerAdd(RegisterDTO param){
        return registerServer.registerAdd(param);
    }

}
