package com.ccg.struts.beans;

import lombok.Data;

@Data
public class User {

	private String userName;
	private String password;
	private String email;
	private Integer phoneNumber;
}
