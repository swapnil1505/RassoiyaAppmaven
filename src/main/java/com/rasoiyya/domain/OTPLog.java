package com.rasoiyya.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * @author ravi.shakya
 *
 */
@Entity
@Table(name = "otplog")
@NamedQuery(name = "OTPLog.findAll", query = "SELECT o FROM OTPLog o")
@EntityListeners(AuditingEntityListener.class)
public class OTPLog extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "otp_id")
	private int otpId;

	@Column(name = "mobile", unique = true)
	private String mobile;

	@Column(name = "otp")
	private String otp;

	public OTPLog() {
	}

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}