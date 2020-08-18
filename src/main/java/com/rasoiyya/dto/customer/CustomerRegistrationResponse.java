package com.rasoiyya.dto.customer;

import java.io.Serializable;

public class CustomerRegistrationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String status_code;
	private String status_message;
	private String response_time;
	private String api_log_id;
	private String requestuid;
	
	public CustomerRegistrationResponse() {
		
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
	
	public String getRequestuid() {
		return requestuid;
	}
	
	public void setRequestuid(String requestuid) {
		this.requestuid = requestuid;
	}
	
	@Override
	public String toString() {
		return "CustomerRegistrationResponse [status=" + status + ", status_code=" + status_code + ", status_message="
				+ status_message + ", response_time=" + response_time + ", api_log_id=" + api_log_id + ", requestuid="
				+ requestuid + "]";
	}
}
