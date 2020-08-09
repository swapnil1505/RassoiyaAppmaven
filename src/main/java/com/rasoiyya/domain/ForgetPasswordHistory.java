package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the forget_password_history database table.
 * 
 */
@Entity
@Table(name="forget_password_history")
@NamedQuery(name="ForgetPasswordHistory.findAll", query="SELECT f FROM ForgetPasswordHistory f")
@EntityListeners(AuditingEntityListener.class)
public class ForgetPasswordHistory extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="forget_password_id")
	private int forgetPasswordId;

	@Column(name="current_password")
	private String currentPassword;

	@Column(name="new_password")
	private String newPassword;

	@Column(name="reset_by")
	private String resetBy;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	private UserLogin userLogin;

	public ForgetPasswordHistory() {
	}

	public int getForgetPasswordId() {
		return this.forgetPasswordId;
	}

	public void setForgetPasswordId(int forgetPasswordId) {
		this.forgetPasswordId = forgetPasswordId;
	}

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getResetBy() {
		return this.resetBy;
	}

	public void setResetBy(String resetBy) {
		this.resetBy = resetBy;
	}

	public UserLogin getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

}