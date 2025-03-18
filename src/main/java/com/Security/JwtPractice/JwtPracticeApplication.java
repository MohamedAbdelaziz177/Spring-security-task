package com.Security.JwtPractice;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
public class JwtPracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwtPracticeApplication.class, args);

	//byte[] keyBytes = new byte[32]; // 256-bit key (recommended)
	//new SecureRandom().nextBytes(keyBytes);

	//String base64Key = Base64.getEncoder().withoutPadding().encodeToString(keyBytes);
	//System.out.println("Generated Secret Key: " + base64Key);

	}


}
