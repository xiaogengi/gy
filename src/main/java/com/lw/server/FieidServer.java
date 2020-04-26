package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.Fieid;
import com.lw.pojo.User;

import java.util.List;

public interface FieidServer {

    JSONObject queryAllFieid();

    int saveFieid(Fieid param);

    int deleteFieidById(Integer id);
}
