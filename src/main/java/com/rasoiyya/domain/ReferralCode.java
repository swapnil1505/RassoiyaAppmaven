package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the referral_code database table.
 * 
 */
@Entity
@Table(name="referral_code")
@NamedQuery(name="ReferralCode.findAll", query="SELECT r FROM ReferralCode r")
public class ReferralCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="referral_code_id")
	private int referralCodeId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="referral_code")
	private String referralCode;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserLogin userLogin;

	//bi-directional many-to-one association to AdminReferral
	@ManyToOne
	@JoinColumn(name="admin_referral_id")
	private AdminReferral adminReferral;

	public ReferralCode() {
	}

	public int getReferralCodeId() {
		return this.referralCodeId;
	}

	public void setReferralCodeId(int referralCodeId) {
		this.referralCodeId = referralCodeId;
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

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getReferralCode() {
		return this.referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public UserLogin getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public AdminReferral getAdminReferral() {
		return this.adminReferral;
	}

	public void setAdminReferral(AdminReferral adminReferral) {
		this.adminReferral = adminReferral;
	}

}