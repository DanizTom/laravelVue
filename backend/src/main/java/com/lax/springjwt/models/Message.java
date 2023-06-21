package com.lax.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	String subject;
	String message;
	Long coachid;
	Long clientid;
	String name;
	String toemail;
	String fromemail;
	@Lob
	private byte[] file;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getCoachid() {
		return coachid;
	}

	public void setCoachid(Long coachid) {
		this.coachid = coachid;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToemail() {
		return toemail;
	}

	public void setToemail(String toemail) {
		this.toemail = toemail;
	}

	public String getFromemail() {
		return fromemail;
	}

	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
