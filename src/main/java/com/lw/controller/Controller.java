package com.lw.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        try {
            String userId =(String) request.getSession().getAttribute("userId");

            if("".equals(userId) || userId == null){
                modelAndView.setViewName("/login/login");
                return modelAndView;
            }
            String userType =(String) request.getSession().getAttribute("userType");
            String userName =(String) request.getSession().getAttribute("userName");
            modelAndView.addObject("type",userType);
            modelAndView.addObject("name",userName);
            modelAndView.setViewName("/index");
            return modelAndView;
        } catch (Exception e){
            e.printStackTrace();
            modelAndView.setViewName("/login/login");
            return modelAndView;
        }
    }

}
