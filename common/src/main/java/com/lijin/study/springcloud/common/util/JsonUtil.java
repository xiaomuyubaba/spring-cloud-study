package com.lijin.study.springcloud.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setDateFormat(new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss")));

        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }


    /**
     * 将对象转成JSON
     *
     * @param obj 对象
     * @param <T> 对象类型
     * @return JSON字符串
     */
    public static <T> String toJson(T obj) {
        return toJson(obj, false);
    }

    /**
     * 将对象转成格式化后的JSON
     *
     * @param obj 对象
     * @param <T> 对象类型
     * @return JSON字符串
     */
    public static <T> String toJsonWithFormat(T obj) {
        return toJson(obj, true);
    }

    /**
     * 将对象转成JSON
     *
     * @param obj 对象
     * @param <T> 对象类型
     * @return JSON字符串
     */
    private static <T> String toJson(T obj, boolean isFormatted) {
        try {
            if (isFormatted) {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } else {
                return objectMapper.writeValueAsString(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException("write ojb to json string failed!", e);
        }
    }

    /**
     * 将JSON转成对象
     *
     * @param jsonString JSON字符串
     * @param clazz      结果对象类型
     * @return <T> T
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException("parse json string error: " + jsonString, e);
        }
    }

}
