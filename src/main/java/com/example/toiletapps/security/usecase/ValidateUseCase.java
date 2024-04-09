package com.example.toiletapps.security.usecase;

public interface ValidateUseCase {
    boolean check(String token);
    boolean checkAdmin(String token);
}
