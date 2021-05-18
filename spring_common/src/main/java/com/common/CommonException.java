package com.common;

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    public CommonException(String message) {
        super(message);
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

}
