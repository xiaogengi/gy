package com.lw.pojo.dto;

/**
 * @program: gy_system
 * @description:
 * @author: gzk
 * @create: 2020-04-29 17:56
 **/
public class OrderDTO {

    private String fieidName;
    private String startTime;
    private String endTime;
    private String gyDate;
    private String userName;

    public String getFieidName() {
        return fieidName;
    }

    public void setFieidName(String fieidName) {
        this.fieidName = fieidName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
