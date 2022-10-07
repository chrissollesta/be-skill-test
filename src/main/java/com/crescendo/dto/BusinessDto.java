package com.crescendo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.crescendo.model.Review;

public class BusinessDto {
	
	private Long id;
	
	private String businessName;
	
	private String address;
	
	private String phone;
	
	private List<ReviewDto> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDto> reviews) {
		this.reviews = reviews;
	}

}
