package com.example.auth.domain.request;

import com.example.auth.domain.entity.User;

public record SignInRequest (
    String email,
    String password
){

}
