package com.example.toiletapps.security.controller;

import com.example.toiletapps.security.usecase.ValidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/validate")
@RequiredArgsConstructor
public class ValidateController {
    private final ValidateUseCase validateUseCase;

    @GetMapping("/valid/{token}")
    public boolean check(@PathVariable("token") String token){
        return validateUseCase.check(token);
    }
}
