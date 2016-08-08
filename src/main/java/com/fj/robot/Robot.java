package com.fj.robot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fj.hiwetoptools.web.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linyu on 2016/8/5.
 */
public class Robot {
    private static final String ITPK_API = "http://i.itpk.cn/api.php";  //茉莉机器人
    // 这里的api_key和api_secret可以自己申请一个
    private static final String KEY = "?api_key=13b52e0033109dd0e3a17570a63b9395&api_secret=rgif59isberr";

    private static final String TULING_API = "http://www.tuling123.com/openapi/api?key=6cf833817aab217eca8bf182b63270c0&info=";

    public static String xiaodoubi(String msg) {
        String url = ITPK_API + KEY + "&question=" + msg;
        Map<String,String> map = new HashMap<>();
        map.put("api_key","13b52e0033109dd0e3a17570a63b9395");
        map.put("api_secret","rgif59isberr");
        map.put("question",msg);
        String result = HttpUtil.get(ITPK_API,map);
        result = SignUtil.doSign(msg, result);
        return result;
    }

    public static String tuling(String msg,String userId){
        String url = TULING_API + msg + "&userId="+userId;
        String result =  HttpUtil.get(url);
        JSONObject j = JSON.parseObject(result);
        return j.getString("text");
    }

}
