package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.dto.LoginDTO;
import com.lw.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private LoginServer loginServer;


    @RequestMapping("/login")
    public JSONObject login(LoginDTO param, HttpServletRequest request){
        return loginServer.login(param, request);
    }


    @RequestMapping("/")
    public ModelAndView loginF(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }

    @RequestMapping("onLogin")
    public ModelAndView onLogin(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        try {
            request.getSession().removeAttribute("userId");
            request.getSession().removeAttribute("userType");
            request.getSession().removeAttribute("userName");
            modelAndView.setViewName("/login/");
            return modelAndView;
        } catch (Exception e){
            modelAndView.setViewName("/error/error");
            return modelAndView;
        }

    }

    @RequestMapping("testSession")
    public void testSession(String userId, HttpServletRequest request){
        request.getSession().setAttribute("userId",userId);
    }


}
