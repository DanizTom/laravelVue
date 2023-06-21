package com.lax.springjwt.payload.response;

import java.util.List;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private String age;
	private String usertype;
	
	private List<String> roles;
	
	private Object usertypeProfile;


	public JwtResponse(String accessToken, Long id, String username, String email, String firstname, String lastname,String age,String usertype, List<String> roles ,Object usertypeProfile) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.usertype=usertype;
		this.roles = roles;
		this.usertypeProfile = usertypeProfile;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
	
	public Object getUsertypeProfile() {
		return usertypeProfile;
	}

	public void setUsertypeProfile(Object usertypeProfile) {
		this.usertypeProfile = usertypeProfile;
	}

}
