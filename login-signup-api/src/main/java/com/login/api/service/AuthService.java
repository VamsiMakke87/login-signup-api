package com.login.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.api.auth.AuthResponse;
import com.login.api.auth.LoginDetails;
import com.login.api.auth.SignUpDetails;
import com.login.api.config.JwtService;
import com.login.api.entity.User;
import com.login.api.repo.UserRepo;

@Service
public class AuthService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	public AuthResponse signUp(SignUpDetails signUpDetails) {
		signUpDetails.setPassword(passwordEncoder.encode(signUpDetails.getPassword()));
		User user = new User(signUpDetails);
		repo.save(user);

		String token = jwtService.generateToken(null, user);

		return new AuthResponse(token);
	}

	public AuthResponse login(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDetails.getEmail(), loginDetails.getPassword()));
		User user = repo.findByEmail(loginDetails.getEmail()).orElseThrow();
		String token = jwtService.generateToken(null, user);

		return new AuthResponse(token);
	}

}
