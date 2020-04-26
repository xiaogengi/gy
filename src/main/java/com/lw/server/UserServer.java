package com.lw.server;

import com.lw.pojo.User;

import java.util.List;

public interface UserServer {

    List<User> queryAllUser();

    int saveUser(User param);

    int deleteUserById(Integer id);

}
