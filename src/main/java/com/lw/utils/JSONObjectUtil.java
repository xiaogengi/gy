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


    public static JSONObject jsonBuildResult(JSONObject param, int code, String msg){
        param.put("code", code);
        param.put("msg",msg);
        return param;
    }

}
