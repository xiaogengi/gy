package com.lw.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping("/")
    public String index(HttpServletRequest request){
        try {
            String userId =(String) request.getSession().getAttribute("userId");
            if("".equals(userId) || userId == null){
                return "/login/login";
            }
            return "/index";
        } catch (Exception e){
            e.printStackTrace();
            return "/login/login";
        }
    }

}
