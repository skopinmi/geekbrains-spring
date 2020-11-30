package com.geekbrains.spring.lesson5.controllers.utils;

import com.geekbrains.spring.lesson5.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorHandlerController {

//    @ExceptionHandler(value = ResourceNotFoundException.class)
//    @ResponseBody
//    public String heightError(ResourceNotFoundException ex) {
//        return ex.getMessage();
//    }

}
