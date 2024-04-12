package com.example.demo.exception;

public class ExistUsernameException extends RuntimeException {
    public ExistUsernameException() {
        super("Your ID has been duplicated");
    }
}
