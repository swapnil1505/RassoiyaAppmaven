package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
@EntityListeners(AuditingEntityListener.class)
public class Admin extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int adminId;

	@Column(name="is_kyc_verified")
	private String isKycVerified;
	
	@Column(name="status")
	private String status;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id_fk")
	private Person person;


	public Admin() {
	}

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getIsKycVerified() {
		return this.isKycVerified;
	}

	public void setIsKycVerified(String isKycVerified) {
		this.isKycVerified = isKycVerified;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}