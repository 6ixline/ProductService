package com.scaler.productservice.advicers;

import com.scaler.productservice.dtos.ErrorResponseDto;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.lang.reflect.InvocationTargetException;
import java.net.NoRouteToHostException;

@ControllerAdvice
@RestController
public class ExceptionAdviser {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setStatus("ERROR");
        dto.setMessage(e.getMessage());
        return dto;
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, NoResourceFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleNoHandlerException(){
        ErrorResponseDto error = new ErrorResponseDto();
        error.setMessage("Route Not Found");
        error.setStatus("Error");
        return error;
    }
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "something went wrong";
    }
}
