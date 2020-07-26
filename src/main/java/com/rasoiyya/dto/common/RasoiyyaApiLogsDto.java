package com.rasoiyya.dto.common;

import java.io.Serializable;
import java.util.Date;

public class RasoiyyaApiLogsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String serviceName;
	private String requestedData;
	private String responseData;
	private String requestuid;
	private String status;
	private String login_ip;
	private String createdBy;
	private String modifiedBy;
	private Date requestTime;
	
	
	
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRequestedData() {
		return requestedData;
	}
	public void setRequestedData(String requestedData) {
		this.requestedData = requestedData;
	}
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	public String getRequestuid() {
		return requestuid;
	}
	public void setRequestuid(String requestuid) {
		this.requestuid = requestuid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
