package com.lw.utils;

import com.lw.mapper.UserMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: gy_system
 * @description:
 * @author: gzk
 * @create: 2020-04-24 13:13
 **/
@Component
public class AccountUtil implements InitializingBean {


    @Autowired
    private UserMapper userMapper;

    public volatile static List<String> ACCOUNT_LIST = new ArrayList<String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCOUNT_LIST = userMapper.queryAllUserAccount();
    }

    // todo 注册时候加
    public void addAccount(String account){
        ACCOUNT_LIST.add(account);
    }
}
