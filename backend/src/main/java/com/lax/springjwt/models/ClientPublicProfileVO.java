package com.lax.springjwt.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientPublicProfileVO implements Serializable {

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

	String grade;

	String city;

	private byte[] profpic;
	
	List<CoachReviews> contractorReviewsByContractorId; 


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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public List<CoachReviews> getContractorReviewsByContractorId() {
		return contractorReviewsByContractorId;
	}

	public void setContractorReviewsByContractorId(List<CoachReviews> contractorReviewsByContractorId) {
		this.contractorReviewsByContractorId = contractorReviewsByContractorId;
	}

}
