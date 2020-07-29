package com.rasoiyya.dto.admin;

import java.io.Serializable;
import java.util.List;

import com.rasoiyya.dto.common.AddressResponse;

public class ViewAdminProfileResponse  implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String user_name;
	private String password;
	private String admin_id;
	private String user_id;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String date_of_birth;
	private String gender;
	private String is_kyc_verified;
	private String admin_status;
	private String govt_id_type;
	private String govt_id_no;
	private String email_id;
	private String created_date;
	private String modified_date;
	private String created_by;
	private String modified_by;
	private String status;
	private String status_code;
	private String status_message;
	private String response_time;
	private String api_log_id;
	private String requestuid;
	private List<AddressResponse> addressList;
	
	public String getAdmin_status() {
		return admin_status;
	}
	public void setAdmin_status(String admin_status) {
		this.admin_status = admin_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	public String getApi_log_id() {
		return api_log_id;
	}
	public void setApi_log_id(String api_log_id) {
		this.api_log_id = api_log_id;
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
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
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
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public List<AddressResponse> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressResponse> addressList) {
		this.addressList = addressList;
	}
	@Override
	public String toString() {
		return "ViewAdminProfileResponse [user_name=" + user_name + ", password=" + password + ", admin_id=" + admin_id
				+ ", user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile_number=" + mobile_number + ", date_of_birth=" + date_of_birth + ", gender=" + gender
				+ ", is_kyc_verified=" + is_kyc_verified + ", admin_status=" + admin_status + ", govt_id_type="
				+ govt_id_type + ", govt_id_no=" + govt_id_no + ", email_id=" + email_id + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", created_by=" + created_by + ", modified_by="
				+ modified_by + ", status=" + status + ", status_code=" + status_code + ", status_message="
				+ status_message + ", response_time=" + response_time + ", api_log_id=" + api_log_id + ", requestuid="
				+ requestuid + ", addressList=" + addressList + "]";
	}
	
	
	
}
