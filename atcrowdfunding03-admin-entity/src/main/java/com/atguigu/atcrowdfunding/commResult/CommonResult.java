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
    private Integer status;
    private String message;
    private T data;

    public static <E> CommonResult<E> success(String message) {
        return new CommonResult<E>(200,message,null);
    }

    public static <E> CommonResult<E> failed(String message) {
        return new CommonResult<E>(444,message,null);
    }

}
