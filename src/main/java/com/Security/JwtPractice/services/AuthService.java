package com.Security.JwtPractice.services;

import com.Security.JwtPractice.DTOs.AuthResponseDto;
import com.Security.JwtPractice.DTOs.LoginDto;
import com.Security.JwtPractice.DTOs.RegisterDto;
import com.Security.JwtPractice.user.Role;
import com.Security.JwtPractice.user.User;
import com.Security.JwtPractice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthResponseDto Register(RegisterDto registerDto) {

        var user =  User.builder()
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return  AuthResponseDto.builder().token(jwtToken).succeeded(true).build();
    }

    public AuthResponseDto Login(LoginDto loginDto) {

        try {
            var auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

            var user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();

            var jwtToken = jwtService.generateToken(user);

            return  AuthResponseDto.builder().token(jwtToken).succeeded(true).build();
        }
        catch (Exception e) {

            return null;
        }



    }


}
