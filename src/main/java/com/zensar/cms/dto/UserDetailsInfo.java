package com.zensar.cms.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zensar.cms.model.UserDetails;
/**
 * @author Grishma Kagde
 *
 * Course Management System UserDetails dto class.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailsInfo {
	
	private  String role;
	
	private Integer userId;

	private String lastname;
	
	private String firstname;
	
	private String username;
	
	private String password;
	
	private String mobileNumber;

	private String address;
	
	private String roleName;

	private Integer createdBy;
		
	private Integer updatedBy;

	public UserDetailsInfo() {
		
	}
	
	

	public UserDetailsInfo(UserDetails userDetail) {
		super();
		this.userId = userDetail.getUserId();
		this.lastname = userDetail.getLastname();
		this.firstname = userDetail.getFirstname();
		this.username = userDetail.getUsername();
		this.password = userDetail.getPassword();
		this.mobileNumber = userDetail.getMobileNumber();
		this.address = userDetail.getAddress();
		this.roleName = userDetail.getRoleName();
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Integer getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}



	public Integer getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	

		
}
