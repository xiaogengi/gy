package com.lw.pojo;

/**
 * 预约订单pojo
 */
public class Order {

    private Integer id;
    private Integer userId;
    private Integer fieid;
    private String startTime;
    private String endTime;
    private String gyDate;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGyDate() {
        return gyDate;
    }

    public void setGyDate(String gyDate) {
        this.gyDate = gyDate;
    }
}
