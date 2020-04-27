package com.lw.server;


import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.dto.RegisterDTO;

public interface RegisterServer {

    JSONObject registerAdd(RegisterDTO param);
}
