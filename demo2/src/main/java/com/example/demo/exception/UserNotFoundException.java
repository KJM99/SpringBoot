package com.example.demo.exception;

public class UserNotFoundException extends IllegalArgumentException{
    public UserNotFoundException(String s) {
        super(s);
    }
}
