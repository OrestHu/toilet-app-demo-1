package com.example.toiletapps.security.usecase.impl;

import com.example.toiletapps.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.toiletapps.security.model.UserAccount;
import com.example.toiletapps.security.model.req.RegisterRequest;
import com.example.toiletapps.security.service.UserAccountService;
import com.example.toiletapps.security.usecase.RegisterCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterCreateUseCaseImpl implements RegisterCreateUseCase {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;
    @Override
    public void registerAcc(RegisterRequest request) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(request);
        userAccountService.createUserAccount(userAccount);
    }
}
