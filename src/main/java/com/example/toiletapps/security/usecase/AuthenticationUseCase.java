package com.example.toiletapps.security.usecase;

import com.example.toiletapps.security.exception.GlobalExceptionHandler;
import com.example.toiletapps.security.model.AccessToken;
import com.example.toiletapps.security.model.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest request) throws GlobalExceptionHandler;
}
