package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.FieidMapper;
import com.lw.pojo.Fieid;
import com.lw.pojo.dto.UpdateFieidDTO;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.FieidServer;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class FieidServerImpl implements FieidServer {


    @Autowired
    private FieidMapper fieidMapper;

    @Override
    public JSONObject queryAllFieid() {
        try {
            List<Fieid> fieids = fieidMapper.queryAllFieid();
            return JSONObjectUtil.jsonUtil(fieids);
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
        }
    }

    /**
     * 返回错误码
     *  0  创建用户失败
     *  1  创建用户成功
     * @param param
     * @return
     */
    @Override
    public int saveFieid(Fieid param) {
        try {
            return fieidMapper.saveFieid(param);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteFieidById(Integer id) {
        try {
            return fieidMapper.deleteFieidById(id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ModelAndView queryFieidById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            modelAndView.addObject("fieid", fieidMapper.queryFieidById(id));
            modelAndView.setViewName("/fieid/editFieid");
            return modelAndView;
        } catch (Exception e){
            e.printStackTrace();
            modelAndView.setViewName("/error/error");
            return modelAndView;
        }
    }

    @Override
    public int updateFieidById(UpdateFieidDTO param) {
        try {
            return fieidMapper.updateFieidById(param);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}

