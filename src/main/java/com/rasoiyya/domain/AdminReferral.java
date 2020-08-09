package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the admin_referral database table.
 * 
 */
@Entity
@Table(name="admin_referral")
@NamedQuery(name="AdminReferral.findAll", query="SELECT a FROM AdminReferral a")
@EntityListeners(AuditingEntityListener.class)
public class AdminReferral extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_referral_id")
	private int adminReferralId;

	@Column(name="is_active")
	private String isActive;

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

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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