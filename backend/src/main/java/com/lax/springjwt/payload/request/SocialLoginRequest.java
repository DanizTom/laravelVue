package com.lax.springjwt.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;

/**
 * Attributes of social user like google/facebook
 *
 */
public class SocialLoginRequest {

	@NotBlank
	private String username;

	private String email;

	private Set<String> role;

	private String usertype;

	private String uid;
	

	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
