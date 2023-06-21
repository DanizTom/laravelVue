package com.lax.springjwt.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

//@ApiModel(value = "UserVO", description = "Input for User")
public class UserVO implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 80)
	@NotNull
	private String username;

	@Size(max = 80)
	@NotNull
	private String email;

	@Size(max = 80)
	@NotNull
	private String firstname;

	@Size(max = 80)
	@NotNull
	private String lastname;

	@Size(max = 80)
	@NotNull
	private String age;

	public String city;

	public String[] coachSkills;

	private byte[] coachProfpic;

	private byte[] clientProfpic;

	private String address1;

	private String address2;

	private String state;

	private String zipcode;

	private String homephone;

	private String mobile;

	private String aboutme;
	private String education;
	private String experience;

	// Social media attributes
	String facebook;
	String twitter;
	String youtube;
	String linkedin;
	String websitelink;

	/*
	 * @JsonProperty("usertypeProfile") public void
	 * setUsertypeProfileAttributes(Map<String, String> usertypeProfile) { //
	 * Contrator attributes from the form this.coachCity =
	 * usertypeProfile.get("city"); this.coachSkills= usertypeProfile.get("skills");
	 * //Client attributes from the form this.clientCity =
	 * usertypeProfile.get("city"); }
	 */

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

	public String[] getCoachSkills() {
		return coachSkills;
	}

	public void setCoachSkills(String[] coachSkills) {
		this.coachSkills = coachSkills;
	}

	public byte[] getCoachProfpic() {
		return coachProfpic;
	}

	public void setCoachProfpic(byte[] coachProfpic) {
		this.coachProfpic = coachProfpic;
	}

	public byte[] getClientProfpic() {
		return clientProfpic;
	}

	public void setClientProfpic(byte[] clientProfpic) {
		this.clientProfpic = clientProfpic;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getWebsitelink() {
		return websitelink;
	}

	public void setWebsitelink(String websitelink) {
		this.websitelink = websitelink;
	}
}
