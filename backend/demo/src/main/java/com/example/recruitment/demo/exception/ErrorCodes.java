package com.example.recruitment.demo.exception;

public enum ErrorCodes {
    JOB_NOT_FOUND(1000),
    JOB_NOT_VALID(1001),

    POSITION_NOT_FOUND(2000),
    POSITION_NOT_VALID(2001),

    POST_NOT_FOUND(3000),
    POST_NOT_VALID(3001);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}