package com.example.toiletapps.security.model.req;

import jakarta.validation.constraints.*;

public record RegisterRequest(
                            @NotBlank(message = "Email must be not blank")
                            @Email(message = "Please enter a valid email address.")
                            String username,
                            @Size(min = 8, message = "Password must have at least {min} characters")
                            @Size(max = 32, message = "Password must have at most {max} characters")
                            @NotBlank(message = "Password must be not blank")
                            String password) {
}
