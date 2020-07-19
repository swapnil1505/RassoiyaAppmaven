package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the referral_code_log database table.
 * 
 */
@Entity
@Table(name="referral_code_log")
@NamedQuery(name="ReferralCodeLog.findAll", query="SELECT r FROM ReferralCodeLog r")
public class ReferralCodeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="referral_code_log_id")
	private int referralCodeLogId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="from_referral_code")
	private String fromReferralCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne
	@JoinColumn(name="from_user_id")
	private UserLogin userLogin1;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne
	@JoinColumn(name="to_user_id")
	private UserLogin userLogin2;

	public ReferralCodeLog() {
	}

	public int getReferralCodeLogId() {
		return this.referralCodeLogId;
	}

	public void setReferralCodeLogId(int referralCodeLogId) {
		this.referralCodeLogId = referralCodeLogId;
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

	public String getFromReferralCode() {
		return this.fromReferralCode;
	}

	public void setFromReferralCode(String fromReferralCode) {
		this.fromReferralCode = fromReferralCode;
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

	public UserLogin getUserLogin1() {
		return this.userLogin1;
	}

	public void setUserLogin1(UserLogin userLogin1) {
		this.userLogin1 = userLogin1;
	}

	public UserLogin getUserLogin2() {
		return this.userLogin2;
	}

	public void setUserLogin2(UserLogin userLogin2) {
		this.userLogin2 = userLogin2;
	}

}