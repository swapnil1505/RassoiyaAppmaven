package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jhi_persistent_audit_evt_data database table.
 * 
 */
@Entity
@Table(name="jhi_persistent_audit_evt_data")
@NamedQuery(name="JhiPersistentAuditEvtData.findAll", query="SELECT j FROM JhiPersistentAuditEvtData j")
public class JhiPersistentAuditEvtData implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JhiPersistentAuditEvtDataPK id;

	private String value;

	//bi-directional many-to-one association to JhiPersistentAuditEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private JhiPersistentAuditEvent jhiPersistentAuditEvent;

	public JhiPersistentAuditEvtData() {
	}

	public JhiPersistentAuditEvtDataPK getId() {
		return this.id;
	}

	public void setId(JhiPersistentAuditEvtDataPK id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public JhiPersistentAuditEvent getJhiPersistentAuditEvent() {
		return this.jhiPersistentAuditEvent;
	}

	public void setJhiPersistentAuditEvent(JhiPersistentAuditEvent jhiPersistentAuditEvent) {
		this.jhiPersistentAuditEvent = jhiPersistentAuditEvent;
	}

}