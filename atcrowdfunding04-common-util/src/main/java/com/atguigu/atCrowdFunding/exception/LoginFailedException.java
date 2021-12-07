package com.atguigu.atCrowdFunding.exception;

/**
 * @auther konglingyang
 * @date 2021/12/6 10:55
 * 登陆失败异常
 */
public class LoginFailedException extends RuntimeException {

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
