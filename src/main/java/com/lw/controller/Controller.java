package com.lw.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping("/")
    public String index(){
        return "/index";
    }

}
