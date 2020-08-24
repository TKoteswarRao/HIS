package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ACC_STATUS")
	private String accStatus;

	@Column(name = "CITY_ID")
	private Integer cityId;

	@Column(name = "STATE_ID")
	private Integer stateId;

	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_PWD")
	private String userPWD;

	@Column(name = "IS_ACTIVE")
	private String isActive;

	@Column(name = "USER_MOBILE")
	private Long userMobile;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;

}
