package com.lax.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 120)
	private String username;

	@NotBlank
	@Size(max = 120)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	

	@Size(max = 120)
	private String firstname;
	
	@Size(max = 120)
	private String lastname;
	

	@Size(max = 120)
	private String age;
	
	@Size(max = 120)
	private String usertype;
	
	@Size(max = 400)
	private String resettoken;
	
	
	@Size(max = 400)
	private String decryptedpassword;
	
	
	@Size(max = 40)
	private String socialuser;
	
	
	


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password, String usertype) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public String getResettoken() {
		return resettoken;
	}

	public void setResettoken(String resettoken) {
		this.resettoken = resettoken;
	}

	public String getDecryptedpassword() {
		return decryptedpassword;
	}

	public void setDecryptedpassword(String decryptedpassword) {
		this.decryptedpassword = decryptedpassword;
	}

	public String getSocialuser() {
		return socialuser;
	}

	public void setSocialuser(String socialuser) {
		this.socialuser = socialuser;
	}


}
