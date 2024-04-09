package com.example.toiletapps.security.controller;

import com.example.toiletapps.security.usecase.ValidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/validate")
@RequiredArgsConstructor
public class ValidateController {
    private final ValidateUseCase validateUseCase;

    @GetMapping("/valid/{token}")
    public boolean check(@PathVariable("token") String token){
        return validateUseCase.check(token);
    }

    @GetMapping("/checkAdmin/{token}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean checkAdmin(@PathVariable("token") String user_id){
        return validateUseCase.checkAdmin(user_id);
    }
}
