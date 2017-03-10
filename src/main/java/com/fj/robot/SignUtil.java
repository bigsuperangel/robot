package com.fj.robot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fj.hiwetoptools.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyu on 2016/8/5.
 */

public class SignUtil {
    private static List<String> QUESTIONS = new ArrayList<String>();
    static{
        QUESTIONS.add("观音灵签");
        QUESTIONS.add("财神爷灵签");
        QUESTIONS.add("月老灵签");
        QUESTIONS.add("笑话");
    }

    public static String doSign(String question,String result){
        if(!QUESTIONS.contains(question)){
            return result;
        }
        JSONObject j = JSON.parseObject(result);
        String type = j.getString("type");
        if(StrUtil.isNotBlank(type)){
            StringBuffer sb = new StringBuffer(type);
            if(type.equals("观音灵签")){
                sb.append("\n签语：")
                        .append(j.getString("qianyu"))
                        .append("\n好坏：")
                        .append(j.getString("haohua"))
                        .append("\n诗意：")
                        .append(j.getString("shiyi"))
                        .append("\n解签：")
                        .append(j.getString("jieqian"));
            }else if(type.equals("财神爷灵签")){
                sb.append("\n签语：")
                        .append(j.getString("qianyu"))
                        .append("\n注释：")
                        .append(j.getString("zhushi"))
                        .append("\n解签：")
                        .append(j.getString("jieqian"))
                        .append("\n解说：")
                        .append(j.getString("jieshuo"))
                        .append("\n结果：")
                        .append(j.getString("jieguo"))
                        .append("\n婚姻：")
                        .append(j.getString("hunyin"))
                        .append("\n事业：")
                        .append(j.getString("shiye"))
                        .append("\n功名：")
                        .append(j.getString("gongming"))
                        .append("\n失物：")
                        .append(j.getString("shiwu"))
                        .append("\n出外移居：")
                        .append(j.getString("cwyj"))
                        .append("\n六甲：")
                        .append(j.getString("liujia"))
                        .append("\n交易：")
                        .append(j.getString("jiaoyi"))
                        .append("\n疾病：")
                        .append(j.getString("jibin"))
                        .append("\n诉讼：")
                        .append(j.getString("susong"))
                        .append("\n运途：")
                        .append(j.getString("yuntu"))
                        .append("\n谋事：")
                        .append(j.getString("moushi"))
                        .append("\n合伙做生意：")
                        .append(j.getString("hhzsy"));
            }else if (type.equals("月老灵签")) {
                sb.append("\n签语：")
                        .append(j.getString("qianyu"))
                        .append("\n好坏")
                        .append(j.getString("haohua"))
                        .append("\n诗意：")
                        .append(j.getString("shiyi"))
                        .append("\n解签：")
                        .append(j.getString("jieqian"))
                        .append("\n注释：")
                        .append(j.getString("zhushi"))
                        .append("\n白话")
                        .append(j.getString("baihua"));
            }
            return sb.toString();
        }else{
            StringBuffer sb = new StringBuffer();
            sb.append("\n标题：")
                    .append(j.getString("title"))
                    .append("\n")
                    .append(j.getString("content"));
            return sb.toString();
        }
    }
}

