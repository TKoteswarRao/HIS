package com.his.model;

import java.util.Date;

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
public class User {
	private Integer userId;
	private String accStatus;
	private String firstName;
	private String gender;
	private String email;
	private String lastName;
	private String password;
	private Long phone;
	private String role;
	private Date createdDate;

}
