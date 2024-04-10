package com.example.toiletapps.security.usecase;

import com.example.toiletapps.security.exception.GlobalExceptionHandler;
import com.example.toiletapps.security.model.AccessToken;
import com.example.toiletapps.security.model.req.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthenticationUseCase {
    AccessToken authenticate(@Valid LoginRequest request) throws GlobalExceptionHandler;
}
