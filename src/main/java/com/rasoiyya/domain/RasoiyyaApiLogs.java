package com.rasoiyya.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="rasoiyya_api_logs")
public class RasoiyyaApiLogs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="api_logs_id")
	private int apiLogsId;

	@Column(name="user_id")
	private String userId;
	
	@Column(name="service_name")
	private String serviceName;
	
	@Column(name="requested_data")
	private String requestedData;
	
	@Column(name="responsed_data")
	private String responsedData;
	
	@Column(name="requestuid")
	private String requestuid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="request_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestTime;
	
	@Column(name="response_time")
	private Date responseTime;
		
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_by")
	private String modifiedBy;

	public int getApiLogsId() {
		return apiLogsId;
	}

	public void setApiLogsId(int apiLogsId) {
		this.apiLogsId = apiLogsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getResponsedData() {
		return responsedData;
	}

	public void setResponsedData(String responsedData) {
		this.responsedData = responsedData;
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

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
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
