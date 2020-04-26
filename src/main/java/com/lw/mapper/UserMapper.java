package com.lw.mapper;

import com.lw.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select(" select * from user")
    public List<User> queryAllUser();

    @Insert(" insert into user (user_name, user_account, user_pwd, user_type) " +
            "values" +
            " (#{param.userName}, #{param.userAccount}, #{param.userPwd}, #{param.userType})")
    int saveUser(@Param("param") User param);

    @Select("select user_account from user")
    List<String> queryAllUserAccount();
}
