package com.example.UPIBProjekat.security;

import java.util.List;

public class JWTResponse {

	
private static final long serialVersionUID = -8091879091924046844L;
	
	
	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private Integer id;
	private String username;
	private List<String> roles;

	public JWTResponse(String accessToken, Integer id, String username, List<String> roles,String refreshToken, String type ) {
		this.token = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.type = type;
	}
	

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
	
}
