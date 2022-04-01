package com.pichincha.msastore.handler;

import com.pichincha.msastore.dto.ErrorResponse;
import com.pichincha.msastore.exception.NotFoundStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundStoreException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundStoreException(NotFoundStoreException exception) {
        return ErrorResponse.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        String errorFields = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(", "));
        return ErrorResponse.builder()
                .code("HTTP-400")
                .message("Invalid Fields: " + errorFields)
                .build();
    }

}
