package com.lw.mapper;

import com.lw.pojo.Fieid;
import com.lw.pojo.dto.UpdateFieidDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FieidMapper {


    @Select("select f.*,u.user_type as type, concat(f.start_time,  ' - ' ,f.end_time) as time from fieid f,`user` u where u.user_id = #{userId}")
    List<Fieid> queryAllFieid(@Param("userId") String userId);


    @Insert("insert into fieid (name, status, start_time, end_time, img_url) " +
            "values" +
            " (#{param.name}, #{param.status}, #{param.startTime}, #{param.endTime}, #{param.imgUrl})")
    int saveFieid(@Param("param") Fieid param);


    @Delete("delete from fieid where id = #{id}")
    int deleteFieidById(@Param("id") Integer id);


    @Select("select * from fieid where id = #{id}")
    Fieid queryFieidById(@Param("id") Integer id);


    @Update("update fieid set name = #{param.name}, start_time=#{param.startTime},end_time=#{param.endTime} where id = #{param.id}")
    int updateFieidById(@Param("param") UpdateFieidDTO param);
}
