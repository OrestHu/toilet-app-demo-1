package com.example.toiletapps.security.controller;


import com.example.toiletapps.security.model.req.RegisterRequest;
import com.example.toiletapps.security.usecase.RegisterCreateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterCreateUseCase registerCreateUseCase;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest request){
        registerCreateUseCase.registerAcc(request);
    }
}
