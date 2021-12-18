package com.atguigu.atCrowdFunding.exception;

/**
 * @auther konglingyang
 * @date 2021/12/7 20:48
 */
public class RoleAlreadyException extends RuntimeException {
    public RoleAlreadyException() {
        super();
    }

    public RoleAlreadyException(String message) {
        super(message);
    }

    public RoleAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleAlreadyException(Throwable cause) {
        super(cause);
    }

    protected RoleAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
