package com.Security.JwtPractice;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
public class JwtPracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwtPracticeApplication.class, args);

		String secret = "K7gNU3sdo+OL0wNhqoVWhr3g6s1xYv72ol/pe/Unols=";
		String base64EncodedSecret = Base64.getEncoder().encodeToString(secret.getBytes(StandardCharsets.UTF_8));
		System.out.println("Base64-encoded Secret: " + base64EncodedSecret);

	//byte[] keyBytes = new byte[32]; // 256-bit key (recommended)
	//new SecureRandom().nextBytes(keyBytes);

	//String base64Key = Base64.getEncoder().withoutPadding().encodeToString(keyBytes);
	//System.out.println("Generated Secret Key: " + base64Key);

	}


}
