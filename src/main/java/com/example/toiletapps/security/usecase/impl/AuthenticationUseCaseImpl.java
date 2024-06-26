package com.example.toiletapps.security.usecase.impl;

import com.example.toiletapps.security.model.AccessToken;
import com.example.toiletapps.security.model.req.LoginRequest;
import com.example.toiletapps.security.service.UserAccountService;
import com.example.toiletapps.security.usecase.AuthenticationUseCase;
import com.example.toiletapps.security.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {
    private final AuthenticationManager authenticationManager;
    private final UserAccountService userAccountService;
    private final JwtTokenUtils jwtTokenUtils;
    @Override
    public AccessToken authenticate(LoginRequest request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username().toLowerCase(Locale.ROOT), request.password()));
        }catch (BadCredentialsException e){
            throw new RuntimeException(String.format("Bad username or password"));
        }
        UserDetails userDetails = userAccountService.loadUserByUsername(request.username().toLowerCase(Locale.ROOT));
        String token = jwtTokenUtils.generateJwtToken(userDetails);
        return new AccessToken(token);
    }
}
