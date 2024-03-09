package com.example.toiletapps.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handlerException(RuntimeException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .findFirst()
                .orElseThrow();
        String messageError = String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());

        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, messageError);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handlerBadCredentialsException(){
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "Unknown error occurred");
    }

}
