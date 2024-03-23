package com.example.toiletapps.security.model.req;

import jakarta.validation.constraints.*;

public record RegisterRequest(
                            @NotBlank(message = "Username must be not blank")
                            @Size(min = 5, message = "Name must have at least {min} characters")
                            @Size(max = 25, message = "Name must have at most {max} characters")
                            @Email(message = "Please enter a valid email address.")
                            String username,
                            @Size(min = 8, message = "Name must have at least {min} characters")
                            @Size(max = 32, message = "Name must have at most {max} characters")
                            @NotBlank(message = "Password must be not blank")
                            String password) {
}
