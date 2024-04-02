package com.example.toiletapps.security.usecase.impl;

import com.example.toiletapps.security.usecase.ValidateUseCase;
import com.example.toiletapps.security.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUseCaseImpl implements ValidateUseCase {
    private final JwtTokenUtils jwtTokenUtils;
    @Override
    public boolean check(String token) {
        return jwtTokenUtils.checkValidToken(token);
    }
}
