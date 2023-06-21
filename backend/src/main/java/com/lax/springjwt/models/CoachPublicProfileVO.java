package com.lax.springjwt.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CoachPublicProfileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Size(max = 80)
	String mobile;

	@Size(max = 80)
	
	String homephone;

	@Size(max = 1000)
	String[] skills;
	
	@Size(max = 1000)
	@NotNull
	String aboutme;
	
	@Size(max = 500)
	@NotNull
	String education;
	
	@Size(max = 500)
	@NotNull
	String experience;
	
	
	

	@Size(max = 100)
	String city;

	private byte[] profpic;

	List<CoachReviews> coachReviewsByCoachId;
	@Size(max = 500)
	String facebook;
	
	@Size(max = 500)
	String twitter;
	
	@Size(max = 500)
	String youtube;
	
	@Size(max = 500)
	String linkedin;
	
	@Size(max = 500)
	String websitelink;

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

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

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

	public byte[] getProfpic() {
		return profpic;
	}

	public void setProfpic(byte[] profpic) {
		this.profpic = profpic;
	}

	public @Size(max = 5000) String[] getSkills() {
		return skills;
	}

	public void setSkills(@Size(max = 5000) String[] skills) {
		this.skills = skills;
	}

	public List<CoachReviews> getCoachReviewsByCoachId() {
		return coachReviewsByCoachId;
	}

	public void setCoachReviewsByCoachId(List<CoachReviews> coachReviewsByCoachId) {
		this.coachReviewsByCoachId = coachReviewsByCoachId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
