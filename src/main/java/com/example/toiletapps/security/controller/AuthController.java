package com.example.toiletapps.security.controller;

import com.example.toiletapps.security.model.AccessToken;
import com.example.toiletapps.security.model.LoginRequest;
import com.example.toiletapps.security.usecase.AuthenticationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/login")
    @SneakyThrows
    public AccessToken auth(@Valid @RequestBody LoginRequest request){
        return authenticationUseCase.authenticate(request);
    }
}
