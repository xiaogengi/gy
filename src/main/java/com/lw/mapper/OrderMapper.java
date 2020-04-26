package com.lw.mapper;

import com.lw.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {


    @Select("select * from `order`")
    List<Order> queryAllOrder();



    @Insert("insert into `order` (user_id, fieid, start_time, end_time, gy_date) " +
            "values" +
            " (#{param.userId}, #{param.fieid}, #{param.startTime}, #{param.endTime}, #{param.gyDate})")
    int saveOrder(@Param("param") Order param);

}
