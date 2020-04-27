package com.lw.pojo;

/**
 * 预约订单pojo
 */
public class Order {

    private Integer id;
    private Integer userId;
    private Integer fieid;
    private String gyDate;    //yyyy-mm-ss

    private String userName;
    private String fieidName;
    private Integer type;

    private Integer type1;

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFieid() {
        return fieid;
    }

    public void setFieid(Integer fieid) {
        this.fieid = fieid;
    }


    public String getGyDate() {
        return gyDate;
    }

    public void setGyDate(String gyDate) {
        this.gyDate = gyDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFieidName() {
        return fieidName;
    }

    public void setFieidName(String fieidName) {
        this.fieidName = fieidName;
    }
}
