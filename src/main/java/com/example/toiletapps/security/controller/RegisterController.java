package com.example.toiletapps.security.controller;

import com.example.toiletapps.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.toiletapps.security.model.UserAccount;
import com.example.toiletapps.security.model.req.RegisterRequest;
import com.example.toiletapps.security.service.UserAccountService;
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
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest request){
        UserAccount userAccount = registerRequestToUserAccountMapper.map(request);
        userAccountService.createUserAccount(userAccount);
    }
}
