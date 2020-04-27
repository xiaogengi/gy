package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;

public interface LoginServer {

    JSONObject login(LoginDTO param, HttpServletRequest request);

}
