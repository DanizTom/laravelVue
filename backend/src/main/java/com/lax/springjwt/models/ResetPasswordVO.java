package com.lax.springjwt.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResetPasswordVO implements Serializable {
	
	@Size(max = 200)
	@NotNull
	private String password;
	
	@Size(max = 200)
	@NotNull
	private String token;
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
