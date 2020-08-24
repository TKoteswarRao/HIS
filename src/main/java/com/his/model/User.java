package com.his.model;

import java.util.Date;

public class User {
	private Integer userId;

	private String accStatus;

	private Integer cityId;

	private Integer stateId;

	private Integer countryId;

	private Date createdDate;

	private Date updatedDate;

	private Date dob;

	private String firstName;

	private String gender;

	private String userEmail;

	private String lastName;

	private String userPWD;

	private Long userMobile;

	@Override
	public String toString() {
		return "UsertEntity [userId=" + userId + ", accStatus=" + accStatus + ", cityId=" + cityId + ", stateId="
				+ stateId + ", countryId=" + countryId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", dob=" + dob + ", firstName=" + firstName + ", gender=" + gender + ", userEmail=" + userEmail
				+ ", lastName=" + lastName + ", userPWD=" + userPWD + ", userMobile=" + userMobile + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public Long getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}

}
