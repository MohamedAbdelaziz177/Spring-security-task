package com.Security.JwtPractice.Controllers;

import com.Security.JwtPractice.DTOs.AuthResponseDto;
import com.Security.JwtPractice.DTOs.LoginDto;
import com.Security.JwtPractice.DTOs.RegisterDto;
import com.Security.JwtPractice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> Register(@RequestBody RegisterDto registerDto) {

        AuthResponseDto authResponseDto = authService.Register(registerDto);

        System.out.println(authResponseDto.getToken());

        return ResponseEntity.ok(authResponseDto);



    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> Login(@RequestBody LoginDto loginDto) {

        AuthResponseDto authResponseDto = authService.Login(loginDto);

        return ResponseEntity.ok(authResponseDto);
    }

    @GetMapping("/DoNothing")
    public String DoNothing(){
        return "Do Nothing";
    }

}
