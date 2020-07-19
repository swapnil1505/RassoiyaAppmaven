package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the admin_referral database table.
 * 
 */
@Entity
@Table(name="admin_referral")
@NamedQuery(name="AdminReferral.findAll", query="SELECT a FROM AdminReferral a")
public class AdminReferral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_referral_id")
	private int adminReferralId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="is_active")
	private String isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	@Lob
	@Column(name="offer_details")
	private String offerDetails;

	@Column(name="role_type")
	private String roleType;

	//bi-directional many-to-one association to ReferralCode
	@OneToMany(mappedBy="adminReferral")
	private List<ReferralCode> referralCodes;

	public AdminReferral() {
	}

	public int getAdminReferralId() {
		return this.adminReferralId;
	}

	public void setAdminReferralId(int adminReferralId) {
		this.adminReferralId = adminReferralId;
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

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	public String getOfferDetails() {
		return this.offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public List<ReferralCode> getReferralCodes() {
		return this.referralCodes;
	}

	public void setReferralCodes(List<ReferralCode> referralCodes) {
		this.referralCodes = referralCodes;
	}

	public ReferralCode addReferralCode(ReferralCode referralCode) {
		getReferralCodes().add(referralCode);
		referralCode.setAdminReferral(this);

		return referralCode;
	}

	public ReferralCode removeReferralCode(ReferralCode referralCode) {
		getReferralCodes().remove(referralCode);
		referralCode.setAdminReferral(null);

		return referralCode;
	}

}