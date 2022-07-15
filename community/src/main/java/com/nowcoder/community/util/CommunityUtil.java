package com.nowcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.security.Key;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {
    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    // MD5加密
    //hello + 3e4a加一个随机字符串再进行加密(salt盐) -> abc123daf456d
    //salt是为了提高安全性
    public static String md5(String key) {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    //获取json格式字符串
    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg",msg);
        if (map != null) {
            for (String key: map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }
    //对方法进行重载，因为有时候这三个参数可能不是全有
    public static String getJSONString(int code, String msg){
        return getJSONString(code, msg,null);
    }

    public static String getJSONString(int code){
        return getJSONString(code, null,null);
    }
}
