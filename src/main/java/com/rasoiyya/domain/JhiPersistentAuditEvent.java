package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the jhi_persistent_audit_event database table.
 * 
 */
@Entity
@Table(name="jhi_persistent_audit_event")
@NamedQuery(name="JhiPersistentAuditEvent.findAll", query="SELECT j FROM JhiPersistentAuditEvent j")
public class JhiPersistentAuditEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="event_id")
	private String eventId;

	@Column(name="event_date")
	private Timestamp eventDate;

	@Column(name="event_type")
	private String eventType;

	private String principal;

	//bi-directional many-to-one association to JhiPersistentAuditEvtData
	@OneToMany(mappedBy="jhiPersistentAuditEvent")
	private List<JhiPersistentAuditEvtData> jhiPersistentAuditEvtData;

	public JhiPersistentAuditEvent() {
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Timestamp getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public List<JhiPersistentAuditEvtData> getJhiPersistentAuditEvtData() {
		return this.jhiPersistentAuditEvtData;
	}

	public void setJhiPersistentAuditEvtData(List<JhiPersistentAuditEvtData> jhiPersistentAuditEvtData) {
		this.jhiPersistentAuditEvtData = jhiPersistentAuditEvtData;
	}

	public JhiPersistentAuditEvtData addJhiPersistentAuditEvtData(JhiPersistentAuditEvtData jhiPersistentAuditEvtData) {
		getJhiPersistentAuditEvtData().add(jhiPersistentAuditEvtData);
		jhiPersistentAuditEvtData.setJhiPersistentAuditEvent(this);

		return jhiPersistentAuditEvtData;
	}

	public JhiPersistentAuditEvtData removeJhiPersistentAuditEvtData(JhiPersistentAuditEvtData jhiPersistentAuditEvtData) {
		getJhiPersistentAuditEvtData().remove(jhiPersistentAuditEvtData);
		jhiPersistentAuditEvtData.setJhiPersistentAuditEvent(null);

		return jhiPersistentAuditEvtData;
	}

}