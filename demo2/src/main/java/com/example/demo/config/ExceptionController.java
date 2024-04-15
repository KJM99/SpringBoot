package com.example.demo.config;

import com.example.demo.exception.ExistUsernameException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ExistUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String existUsernameException(ExistUsernameException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userNotFoundExceptionHandler(
            UserNotFoundException e
    ){
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NotFoundException e){
        return e.getMessage() + " Is NOT FOUND";
    }
}
