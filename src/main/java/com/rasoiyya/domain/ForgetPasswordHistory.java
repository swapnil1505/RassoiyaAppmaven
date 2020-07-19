package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the forget_password_history database table.
 * 
 */
@Entity
@Table(name="forget_password_history")
@NamedQuery(name="ForgetPasswordHistory.findAll", query="SELECT f FROM ForgetPasswordHistory f")
public class ForgetPasswordHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="forget_password_id")
	private int forgetPasswordId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="current_password")
	private String currentPassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

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

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
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