package com.lw.server.impl;


import com.lw.mapper.UserMapper;
import com.lw.pojo.User;
import com.lw.server.UserServer;
import com.lw.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        try {
            return userMapper.queryAllUser();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 返回错误码
     *  04 账号已重复
     *  0  创建用户失败
     *  1  创建用户成功
     * @param param
     * @return
     */
    @Override
    public int saveUser(User param) {
        try {
            if(AccountUtil.ACCOUNT_LIST.contains(param.getUserAccount())){
                return 04;
            }
            int i = userMapper.saveUser(param);
            if(i < 1){
                return 0;
            }
            AccountUtil.ACCOUNT_LIST.add(param.getUserAccount());
            return i;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }



}

