package com.example.toiletapps.security.service;

import com.example.toiletapps.security.model.UserAccount;
import com.example.toiletapps.security.repository.RoleRepository;
import com.example.toiletapps.security.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService implements UserDetailsService {
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;

    public Optional<UserAccount> findUserAccountByUsername(String username){
        return userAccountRepository.findByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = findUserAccountByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User account not found by username: %s", username)
                ));
        return new User(
                account.getUsername(),
                account.getPassword(),
                account.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList()
        );
    }

    public Optional<UserAccount> findUserByUsername(String username){
        return userAccountRepository.findByUsername(username);
    }

    public void createUserAccount(UserAccount userAccount){
        if(userAccountRepository.existsByUsername(userAccount.getUsername())){
            throw new RuntimeException(
                    String.format("This username: %s already exist. Try again!!!", userAccount.getUsername())
            );
        }

        userAccount.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
        userAccountRepository.save(userAccount);
    }

    public Optional<UserAccount> findById(Long id){
        return userAccountRepository.findById(id);
    }
}
