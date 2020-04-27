package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.UserMapper;
import com.lw.pojo.dto.RegisterDTO;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.RegisterServer;
import com.lw.utils.AccountUtil;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServerImpl implements RegisterServer {


    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject registerAdd(RegisterDTO param) {
        try {
            JSONObject result = new JSONObject();
            if(AccountUtil.ACCOUNT_LIST.contains(param.getUserAccount())){
                return JSONObjectUtil.jsonBuildResult(result, 500 , "该账号已被注册，请更换账号！");
            }

            int registerResult = userMapper.register(param);
            if(registerResult == 0){
                return JSONObjectUtil.jsonBuildResult(result, 500, "注册失败，请稍后重试！");
            }

            return JSONObjectUtil.jsonBuildResult(result, 200 , "注册成功");
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
        }
    }
}
