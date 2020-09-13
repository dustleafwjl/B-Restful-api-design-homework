package com.thoughtworks.capability.gtb.restfulapidesign.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handler(RuntimeException exception) {
        String defaultMessage = exception.getMessage();
        return ErrorResult.builder().message(defaultMessage).detail(ErrorResult.Detail.builder().name("test").build()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handler(MethodArgumentNotValidException exception) {
        String defaultMessage = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        return ErrorResult.builder().message(defaultMessage).detail(ErrorResult.Detail.builder().name("test").build()).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorResult all(Exception e){
        return ErrorResult.builder().message("error").detail(ErrorResult.Detail.builder().name("test").build()).build();
    }
}
