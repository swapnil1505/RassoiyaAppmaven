package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="feedback_id")
	private int feedbackId;

	@Lob
	@Column(name="admin_feedback")
	private String adminFeedback;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Lob
	@Column(name="customer_feedback")
	private String customerFeedback;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time")
	private Date dateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_datel")
	private Date lastUpdatedDatel;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="service_type")
	private String serviceType;

	//bi-directional many-to-one association to Cook
	@ManyToOne
	@JoinColumn(name="cook_id")
	private Cook cook;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;

	public Feedback() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getAdminFeedback() {
		return this.adminFeedback;
	}

	public void setAdminFeedback(String adminFeedback) {
		this.adminFeedback = adminFeedback;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerFeedback() {
		return this.customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getLastUpdatedDatel() {
		return this.lastUpdatedDatel;
	}

	public void setLastUpdatedDatel(Date lastUpdatedDatel) {
		this.lastUpdatedDatel = lastUpdatedDatel;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Cook getCook() {
		return this.cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}