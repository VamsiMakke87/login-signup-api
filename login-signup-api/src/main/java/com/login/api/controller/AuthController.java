package com.login.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.login.api.auth.AuthResponse;
import com.login.api.auth.LoginDetails;
import com.login.api.auth.SignUpDetails;
import com.login.api.service.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpDetails signUpDetails) {

		return ResponseEntity.ok(authService.signUp(signUpDetails));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginDetails loginDetails) {
		System.out.println("here");
		return ResponseEntity.ok(authService.login(loginDetails));
	}
	

}
