package com.atguigu.atCrowdFunding.exception;

/**
 * @auther konglingyang
 * @date 2021/12/7 9:48
 */
public class LoginAdminAlreadyException extends RuntimeException {
    public LoginAdminAlreadyException() {
        super();
    }

    public LoginAdminAlreadyException(String message) {
        super(message);
    }

    public LoginAdminAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAdminAlreadyException(Throwable cause) {
        super(cause);
    }

    protected LoginAdminAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
