package leet.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * desc: gosn工具类
 * author: liuxiaozheng
 * time: 2020/5/26  10:25
 **/
public class GsonUtils {
    private static final Gson gson = new Gson();

    public static <T> T fromJson(String json, Type type){
        return gson.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }
}
