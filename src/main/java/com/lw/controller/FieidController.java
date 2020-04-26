package com.lw.controller;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Fieid;
import com.lw.pojo.dto.UpdateFieidDTO;
import com.lw.server.FieidServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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
     *  删除场地信息
     */
    @RequestMapping("deleteFieidById")
    public int deleteFieidById(Integer id){
        return fieidServer.deleteFieidById(id);
    }

    /**
     *  回显场地信息
     */
    @RequestMapping("queryFieidById")
    public ModelAndView queryFieidById(Integer id){
        return fieidServer.queryFieidById(id);
    }

    @RequestMapping("updateFieid")
    public int updateFieid(UpdateFieidDTO param){
        return fieidServer.updateFieidById(param);
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
