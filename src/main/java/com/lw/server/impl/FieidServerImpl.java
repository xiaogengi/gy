package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.FieidMapper;
import com.lw.mapper.UserMapper;
import com.lw.pojo.Fieid;
import com.lw.pojo.User;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.FieidServer;
import com.lw.server.UserServer;
import com.lw.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieidServerImpl implements FieidServer {


    @Autowired
    private FieidMapper fieidMapper;

    @Override
    public JSONObject queryAllFieid() {
        try {
            List<Fieid> fieids = fieidMapper.queryAllFieid();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",0);
            jsonObject.put("count",fieids.size());
            jsonObject.put("data",fieids);
            return jsonObject;
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



}

