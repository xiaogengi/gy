package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Fieid;
import com.lw.server.FieidServer;
import com.lw.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("fieid")
public class FieidController {

    @Autowired
    private FieidServer fieidServer;


    /**
     * 保存场地
     * @param param
     * @return
     */
    @RequestMapping("saveFieid")
    public int saveFieid(Fieid param){
        return fieidServer.saveFieid(param);
    }


    /**
     * 查询所有场地
     * @return
     */
    @RequestMapping("queryAllFieid")
    public JSONObject queryAllFieid(){
        return fieidServer.queryAllFieid();
    }


    /**
     * 打开 field 主页面
     */
    @RequestMapping("fieidList")
    public ModelAndView fieidList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/fieid/fieidList");
        return modelAndView;
    }

}
