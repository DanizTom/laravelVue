package com.lax.springjwt.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ForgotPasswordVO implements Serializable {
	
	@Size(max = 200)
	@NotNull
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
