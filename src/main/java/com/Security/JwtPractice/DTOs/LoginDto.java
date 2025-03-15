package com.Security.JwtPractice.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {

    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Password is required")
    private String password;
}
