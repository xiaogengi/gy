package com.lw.mapper;

import com.lw.pojo.Order;
import com.lw.pojo.dto.OrderDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {


    @Select("<script>" +
                "select " +
                    "r.*," +
                    "u.user_name," +
                    "u.user_type type1," +
                    "f.`name` as fieid_name " +
                "from " +
                    "`order` r, fieid f, `user` u " +
                "where " +
                    "r.user_id = u.user_id" +
                    " and " +
                    "r.fieid = f.id" +
                    "<if test='param.fieidName != null'>" +
                        "and f.name = #{param.fieidName}" +
                    "</if>" +
                    "<if test='param.gyDate != null'>" +
                        "and r.gy_date = #{param.gyDate}" +
                    "</if>" +
                    "<if test='param.userName != null'>" +
                        "and u.user_name = #{param.userName}" +
                    "</if>" +
            "</script>")
    List<Order> queryAllOrder(@Param("param") OrderDTO orderDTO);


    //@Select("select r.*,u.user_name ,u.user_type type ,f.`name` as fieid_name from `order` r, fieid f, `user` u where r.user_id = u.user_id and r.fieid = f.id and u.user_id= #{id}")
    @Select("<script>" +
            "select " +
            "r.*," +
            "u.user_name," +
            "u.user_type type1," +
            "f.`name` as fieid_name " +
            "from " +
            "`order` r, fieid f, `user` u " +
            "where " +
            "r.user_id = u.user_id" +
            " and " +
            "r.fieid = f.id " +
            " and " +
            "u.user_id=#{id}" +
            "<if test='param.fieidName != null'>" +
            " and f.name = #{param.fieidName}" +
            "</if>" +
            "<if test='param.gyDate != null'>" +
            " and r.gy_date = #{param.gyDate}" +
            "</if>" +
            "<if test='param.userName != null'>" +
            " and u.user_name = #{param.userName}" +
            "</if>" +
            "</script>")
    List<Order> queryAllOrderById(@Param("id") String userId,@Param("param") OrderDTO orderDTO);



    @Insert("insert into `order` (user_id, fieid, gy_date, start_time, end_time) " +
            "values" +
            " (#{param.userId}, #{param.fieid}, #{param.gyDate},#{param.startTime},#{param.endTime})")
    int saveOrder(@Param("param") Order param);


    @Delete("delete from `order` where id = #{id}")
    int deleteOrderById(@Param("id") Integer id);

    @Select("select * from `order` where id = #{id}")
    Order queryOrderById(@Param("id") Integer id);

    @Update("update `order` set gy_date = #{param.gyDate} where id = #{param.id}")
    int updateOrder(@Param("param") Order param);
}
