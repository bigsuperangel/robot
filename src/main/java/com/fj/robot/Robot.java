package com.fj.robot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fj.hiwetoptools.web.HttpUtil;
import sun.security.krb5.internal.crypto.Aes128CtsHmacSha1EType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linyu on 2016/8/5.
 */
public class Robot {
    private static final String ITPK_API = "http://i.itpk.cn/api.php";  //茉莉机器人

    private static final String TULING_API = "http://www.tuling123.com/openapi/api";

    public static String xiaodoubi(String msg) {
        Map<String,String> map = new HashMap<>();
        map.put("api_key","13b52e0033109dd0e3a17570a63b9395");
        map.put("api_secret","rgif59isberr");
        map.put("question",msg);
        String result = HttpUtil.get(ITPK_API,map);
        result = SignUtil.doSign(msg, result);
        return result;
    }

    public static String tuling(String msg,String userId){
        Map map = new HashMap();
        map.put("key", "6cf833817aab217eca8bf182b63270c0");
        map.put("info", msg);
        map.put("userId",userId);
        String result =  HttpUtil.get(TULING_API,map);
        JSONObject j = JSON.parseObject(result);
        return j.getString("text");
    }

}
