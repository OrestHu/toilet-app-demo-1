package com.example.toiletapps.security.api.service.impl;

import com.example.toiletapps.security.api.model.CurrentUserApiModel;
import com.example.toiletapps.security.api.service.IdentityApiService;
import com.example.toiletapps.security.model.UserAccount;
import com.example.toiletapps.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService userAccountService;
    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if(authentication == null){
            return Optional.empty();
        }

        String username = authentication.getName();
        return userAccountService
                .findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }

    @Override
    public String currentUserAccountUsername(Long id) {
        UserAccount userAccount = userAccountService.findUserById(id)
                .orElseThrow(() ->
                        new RuntimeException(String.format("User Account not found by id %s", id))
                );
        return userAccount.getUsername();
    }

}
