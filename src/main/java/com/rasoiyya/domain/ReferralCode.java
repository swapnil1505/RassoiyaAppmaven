package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the referral_code database table.
 * 
 */
@Entity
@Table(name="referral_code")
@NamedQuery(name="ReferralCode.findAll", query="SELECT r FROM ReferralCode r")
@EntityListeners(AuditingEntityListener.class)
public class ReferralCode extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="referral_code_id")
	private int referralCodeId;

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