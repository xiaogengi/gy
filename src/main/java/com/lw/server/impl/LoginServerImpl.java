package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.UserMapper;
import com.lw.pojo.User;
import com.lw.pojo.dto.LoginDTO;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.LoginServer;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServerImpl implements LoginServer {


    @Autowired
    private UserMapper userMapper;


    @Override
    public JSONObject login(LoginDTO param, HttpServletRequest request) {
        try {
            User user = userMapper.queryUserById(param.getUserAccount());
            JSONObject result = new JSONObject();

            if(user == null){
                return JSONObjectUtil.jsonBuildResult(result, 500, "账号不存在！");
            }

            if(!user.getUserPwd().equals(param.getUserPwd())){
                return JSONObjectUtil.jsonBuildResult(result, 500, "密码错误！");
            }

            request.getSession().setAttribute("userId", String.valueOf(user.getUserId()));
            request.getSession().setAttribute("userType", String.valueOf(user.getUserType()));

            result =  JSONObjectUtil.jsonBuildResult(result, 200, "登陆成功");
            result.put("userType", user.getUserType() == 1? "管理员": "用户");
            result.put("userName", user.getUserName());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
        }
    }



}
