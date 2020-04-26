package com.lw.mapper;

import com.lw.pojo.Fieid;
import com.lw.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FieidMapper {


    @Select("select * from fieid")
    List<Fieid> queryAllFieid();



    @Insert("insert into fieid (name, status) " +
            "values" +
            " (#{param.name}, #{param.status})")
    int saveFieid(@Param("param") Fieid param);



    @Delete("delete from fieid where id = #{id}")
    int deleteFieidById(@Param("id") Integer id);
}
