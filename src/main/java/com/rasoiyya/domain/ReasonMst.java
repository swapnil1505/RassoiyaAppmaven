package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reason_mst database table.
 * 
 */
@Entity
@Table(name="reason_mst")
@NamedQuery(name="ReasonMst.findAll", query="SELECT r FROM ReasonMst r")
public class ReasonMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reason_id")
	private int reasonId;

	@Lob
	@Column(name="reason_desc")
	private String reasonDesc;

	@Column(name="reason_type")
	private String reasonType;

	public ReasonMst() {
	}

	public int getReasonId() {
		return this.reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonDesc() {
		return this.reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public String getReasonType() {
		return this.reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

}