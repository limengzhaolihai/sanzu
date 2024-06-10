package com.example.demo.Utils;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ResponseConstant {


    private static JSONObject resjson;


    public  static String success(Object obj){
        resjson = new JSONObject();
        resjson.put("code","200");
        resjson.put("message","请求成功");
        resjson.put("data",obj);
        return resjson.toString();
    }


    public static String failure(Object obj){
        resjson = new JSONObject();
        resjson.put("code","201");
        resjson.put("message","请求失败");
        resjson.put("data",obj);
        return resjson.toString();
    }


}
