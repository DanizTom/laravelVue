package com.lax.springjwt.models;

public class CoachReviewsVO {

	private int id;

	String rating;
	String review;

	Long contractorid;
	Long agentid;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getContractorid() {
		return contractorid;
	}

	public void setContractorid(Long contractorid) {
		this.contractorid = contractorid;
	}

	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

}
