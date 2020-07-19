package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jhi_persistent_audit_evt_data database table.
 * 
 */
@Embeddable
public class JhiPersistentAuditEvtDataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="event_id", insertable=false, updatable=false)
	private String eventId;

	private String name;

	public JhiPersistentAuditEvtDataPK() {
	}
	public String getEventId() {
		return this.eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JhiPersistentAuditEvtDataPK)) {
			return false;
		}
		JhiPersistentAuditEvtDataPK castOther = (JhiPersistentAuditEvtDataPK)other;
		return 
			this.eventId.equals(castOther.eventId)
			&& this.name.equals(castOther.name);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eventId.hashCode();
		hash = hash * prime + this.name.hashCode();
		
		return hash;
	}
}