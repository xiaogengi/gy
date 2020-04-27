package com.lw.server.impl;


import com.alibaba.fastjson.JSONObject;
import com.lw.mapper.UserMapper;
import com.lw.pojo.User;
import com.lw.public_parameter.PublicParameter;
import com.lw.server.UserServer;
import com.lw.utils.AccountUtil;
import com.lw.utils.JSONObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServerImpl implements UserServer {


    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject queryAllUser() {
        try {
            return JSONObjectUtil.jsonUtil(userMapper.queryAllUser());
        } catch (Exception e){
            e.printStackTrace();
            return PublicParameter.JSON_OBJECT;
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

    @Override
    public int deleteUserById(Integer id) {
        try {
            return userMapper.deleteUserById(id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUserRoot(Integer id, Integer type) {
        try {
            type = type==1?2:1;
            System.err.println("id = " + id + " ||||||| type = " + type);
            return userMapper.updateUserRoot(id, type);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}

