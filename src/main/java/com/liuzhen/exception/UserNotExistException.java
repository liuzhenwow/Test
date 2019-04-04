package com.liuzhen.exception;

import lombok.Data;

@Data
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }

    private String msg;
    private int age;
    private String code;
}
