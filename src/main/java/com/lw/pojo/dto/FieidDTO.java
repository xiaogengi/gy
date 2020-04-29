package com.lw.pojo.dto;

/**
 * @program: gy_system
 * @description:
 * @author: gzk
 * @create: 2020-04-29 20:15
 **/
public class FieidDTO {

    private String name;


    @Override
    public String toString() {
        return "FieidDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
