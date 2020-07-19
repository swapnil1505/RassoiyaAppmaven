package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the databasechangeloglock database table.
 * 
 */
@Entity
@NamedQuery(name="Databasechangeloglock.findAll", query="SELECT d FROM Databasechangeloglock d")
public class Databasechangeloglock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte locked;

	private String lockedby;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockgranted;

	public Databasechangeloglock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public String getLockedby() {
		return this.lockedby;
	}

	public void setLockedby(String lockedby) {
		this.lockedby = lockedby;
	}

	public Date getLockgranted() {
		return this.lockgranted;
	}

	public void setLockgranted(Date lockgranted) {
		this.lockgranted = lockgranted;
	}

}