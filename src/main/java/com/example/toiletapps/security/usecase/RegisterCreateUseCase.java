package com.example.toiletapps.security.usecase;

import com.example.toiletapps.security.model.req.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RegisterCreateUseCase {
    void registerAcc(@Valid RegisterRequest request);
}
