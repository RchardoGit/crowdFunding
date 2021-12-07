package com.atguigu.atCrowdFunding.exception;

/**
 * @auther konglingyang
 * @date 2021/12/7 9:48
 */
public class UpdateAdminAlreadyException extends RuntimeException {
    public UpdateAdminAlreadyException() {
        super();
    }

    public UpdateAdminAlreadyException(String message) {
        super(message);
    }

    public UpdateAdminAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateAdminAlreadyException(Throwable cause) {
        super(cause);
    }

    protected UpdateAdminAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
