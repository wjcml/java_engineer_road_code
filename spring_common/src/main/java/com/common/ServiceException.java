package com.common;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    public ServiceException(String message) {
        super(message);
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

}
