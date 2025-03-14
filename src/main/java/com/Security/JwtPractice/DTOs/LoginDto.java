package com.Security.JwtPractice.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginDto {

    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Password is required")
    private String password;
}
