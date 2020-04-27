package com.lw.server;

import com.alibaba.fastjson.JSONObject;
import com.lw.pojo.User;


public interface UserServer {

    JSONObject queryAllUser();

    int saveUser(User param);

    int deleteUserById(Integer id);

    int updateUserRoot(Integer id, Integer type);
}
