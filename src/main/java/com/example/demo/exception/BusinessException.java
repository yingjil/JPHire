package com.example.demo.exception;


public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}