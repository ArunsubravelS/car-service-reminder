package com.carservice.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse {

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Long id;
    private String fullName;
    private String email;
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	public UserResponse() {
		// TODO Auto-generated constructor stub
	}
}