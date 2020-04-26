package com.lw.utils;


import com.alibaba.fastjson.JSONObject;

import java.util.List;


public class JSONObjectUtil {


    public static JSONObject jsonUtil(List<?> list){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("count",list.size());
        jsonObject.put("data",list);
        return jsonObject;
    }

}
