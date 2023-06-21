package com.lax.springjwt.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientProfileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Size(max = 100)
	@NotNull
	String username;

	@Size(max = 100)
	@NotNull
	String firstname;
	@Size(max = 100)
	@NotNull
	String lastname;
	@Size(max = 100)
	@NotNull
	String age;

	@Size(max = 100)
	@NotNull
	String email;

	@Size(max = 100)
	@NotNull
	String address1;
	@Size(max = 100)
	@NotNull
	String address2;
	@Size(max = 80)
	@NotNull
	String city;
	@Size(max = 80)
	@NotNull
	String state;
	@Size(max = 80)
	@NotNull
	String zipcode;
	@Size(max = 80)
	@NotNull
	String homephone;
	@Size(max = 80)
	@NotNull
	String mobile;
	@Lob
	private byte[] profpic;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public byte[] getProfpic() {
		return profpic;
	}

	public void setProfpic(byte[] profpic) {
		this.profpic = profpic;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
