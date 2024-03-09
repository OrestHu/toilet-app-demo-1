package com.example.toiletapps.security.mapper.impl;

import com.example.toiletapps.security.model.Role;
import com.example.toiletapps.security.model.UserAccount;
import com.example.toiletapps.security.model.req.RegisterRequest;
import com.example.toiletapps.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapper implements com.example.toiletapps.security.mapper.RegisterRequestToUserAccountMapper {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserAccount map(RegisterRequest source) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(source.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(source.password()));
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException(
                        String.format("User role not found")
                ));
        userAccount.setRoles(List.of(role));
        return userAccount;
    }
}
