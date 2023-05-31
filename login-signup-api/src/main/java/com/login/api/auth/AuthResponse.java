package com.login.api.auth;

public class AuthResponse {

	public AuthResponse() {
	}

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private String token;

}
