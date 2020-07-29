package com.rasoiyya.dto.admin;

import java.io.Serializable;

public class ViewAdminProfileRequest implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String user_name;
	private String requested_time;
	private String requestuid;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRequested_time() {
		return requested_time;
	}
	public void setRequested_time(String requested_time) {
		this.requested_time = requested_time;
	}
	public String getRequestuid() {
		return requestuid;
	}
	public void setRequestuid(String requestuid) {
		this.requestuid = requestuid;
	}
	@Override
	public String toString() {
		return "ViewAdminProfileRequest [user_name=" + user_name + ", requested_time=" + requested_time
				+ ", requestuid=" + requestuid + "]";
	}

}
