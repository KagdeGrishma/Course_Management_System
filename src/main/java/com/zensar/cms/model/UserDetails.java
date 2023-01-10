package com.zensar.cms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author Grishma Kagde
 *
 * Course Management System UserDetails domain class.
 */
@Entity
@Table(name="user_details")
public class UserDetails {
		@Id
		@Column(name = "user_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer userId;

		@Column(name = "lastname")
		private String lastname;
		
		@Column(name = "firstname")
		private String firstname;
		
		@Column(name = "username")
		private String username;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "mobile_number")
		private String mobileNumber;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "role_name")
		private String roleName;
		
		@Column(name = "created_time")
		private LocalDateTime createdTime;
		
		@Column(name = "updated_time")
		private LocalDateTime updatedTime;

		@Column(name = "created_by")
		private Integer createdBy;
			
		@Column(name = "updated_by")
		private Integer updatedBy;

		public LocalDateTime getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(LocalDateTime createdTime) {
			this.createdTime = createdTime;
		}

		public LocalDateTime getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(LocalDateTime updatedTime) {
			this.updatedTime = updatedTime;
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
		

}
