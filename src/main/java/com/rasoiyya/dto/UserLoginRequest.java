package com.rasoiyya.dto;

import java.io.Serializable;

/**
 * 
 * @author ravi.shakya
 *
 */
public class UserLoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user_name;
	private String password;
	private String mobile;
	private String otp;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
