package com.atguigu.atcrowdfunding.commResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther konglingyang
 * @date 2021/12/5 19:55
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    // 用来封装当前请求处理的结果是成功还是失败
    private String result;

    // 请求处理失败时返回的错误消息
    private String message;

    // 要返回的数据
    private T data;

    /**
     * 请求处理成功且不需要返回数据时使用的工具方法
     * @return
     */
    public static <Type> CommonResult<Type> successWithoutData() {
        return new CommonResult<Type>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     * @param data 要返回的数据
     * @return
     */
    public static <Type> CommonResult<Type> successWithData(Type data) {
        return new CommonResult<Type>(SUCCESS, null, data);
    }

    /**
     * 请求处理失败后使用的工具方法
     * @param message 失败的错误消息
     * @return
     */
    public static <Type> CommonResult<Type> failed(String message) {
        return new CommonResult<Type>(FAILED, message, null);
    }




}
