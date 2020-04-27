package com.lw.mapper;

import com.lw.pojo.User;
import com.lw.pojo.dto.RegisterDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select(" select * from user")
    List<User> queryAllUser();

    @Insert(" insert into user (user_name, user_account, user_pwd, user_type) " +
            "values" +
            " (#{param.userName}, #{param.userAccount}, #{param.userPwd}, #{param.userType})")
    int saveUser(@Param("param") User param);

    @Select("select user_account from user")
    List<String> queryAllUserAccount();

    @Delete("delete from `user` where user_id = #{id}")
    int deleteUserById(@Param("id") Integer id);

    @Select("select * from `user` where user_account = #{id}")
    User queryUserById(@Param("id") String userAccount);

    @Insert(" insert into user (user_name, user_account, user_pwd, user_type) " +
            "values" +
            " (#{param.userName}, #{param.userAccount}, #{param.userPwd}, #{param.userType})")
    int register(@Param("param") RegisterDTO param);

    @Update("update user set user_type = #{type} where user_id = #{id}")
    int updateUserRoot(@Param("id") Integer id,@Param("type") Integer type);
}
