package com.rasoiyya.dto;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String user_name;
	private String password;
	
	public UserLoginRequest() {
		
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
