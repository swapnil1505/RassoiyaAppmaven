package com.rasoiyya.dto.admin;

import java.io.Serializable;
import java.util.List;

import com.rasoiyya.dto.common.AddressRequest;

public class AdminRegistrationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	public AdminRegistrationRequest() {
		
	}
	
	private String user_name;
	private String password;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String date_of_birth;
	private String gender;
	private String is_kyc_verified;
	private String govt_id_type;
	private String govt_id_no;
	private String request_time;
	private String requestuid;
	private String email_id;
	private List<AddressRequest> addressList;
	
	
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIs_kyc_verified() {
		return is_kyc_verified;
	}
	public void setIs_kyc_verified(String is_kyc_verified) {
		this.is_kyc_verified = is_kyc_verified;
	}
	public String getGovt_id_type() {
		return govt_id_type;
	}
	public void setGovt_id_type(String govt_id_type) {
		this.govt_id_type = govt_id_type;
	}
	public String getGovt_id_no() {
		return govt_id_no;
	}
	public void setGovt_id_no(String govt_id_no) {
		this.govt_id_no = govt_id_no;
	}
	public List<AddressRequest> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressRequest> addressList) {
		this.addressList = addressList;
	}
	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}
	public String getRequestuid() {
		return requestuid;
	}
	public void setRequestuid(String requestuid) {
		this.requestuid = requestuid;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "AdminRegistrationRequest [user_name=" + user_name + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", mobile_number=" + mobile_number + ", date_of_birth="
				+ date_of_birth + ", gender=" + gender + ", is_kyc_verified=" + is_kyc_verified + ", govt_id_type="
				+ govt_id_type + ", govt_id_no=" + govt_id_no + ", request_time=" + request_time + ", requestuid="
				+ requestuid + ", email_id=" + email_id + ", addressList=" + addressList + "]";
	}
	

}
