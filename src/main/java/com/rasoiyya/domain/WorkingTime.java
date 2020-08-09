package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the working_time database table.
 * 
 */
@Entity
@Table(name="working_time")
@NamedQuery(name="WorkingTime.findAll", query="SELECT w FROM WorkingTime w")
@EntityListeners(AuditingEntityListener.class)
public class WorkingTime extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="working_time_id")
	private int workingTimeId;

	@Column(name="evening_end")
	private Time eveningEnd;

	@Column(name="evening_start")
	private Time eveningStart;

	@Column(name="morning_end")
	private Time morningEnd;

	@Column(name="morning_start")
	private Time morningStart;

	//bi-directional many-to-one association to Cook
	@OneToMany(mappedBy="workingTime")
	private List<Cook> cooks;

	public WorkingTime() {
	}

	public int getWorkingTimeId() {
		return this.workingTimeId;
	}

	public void setWorkingTimeId(int workingTimeId) {
		this.workingTimeId = workingTimeId;
	}

	public Time getEveningEnd() {
		return this.eveningEnd;
	}

	public void setEveningEnd(Time eveningEnd) {
		this.eveningEnd = eveningEnd;
	}

	public Time getEveningStart() {
		return this.eveningStart;
	}

	public void setEveningStart(Time eveningStart) {
		this.eveningStart = eveningStart;
	}

	public Time getMorningEnd() {
		return this.morningEnd;
	}

	public void setMorningEnd(Time morningEnd) {
		this.morningEnd = morningEnd;
	}

	public Time getMorningStart() {
		return this.morningStart;
	}

	public void setMorningStart(Time morningStart) {
		this.morningStart = morningStart;
	}

	public List<Cook> getCooks() {
		return this.cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public Cook addCook(Cook cook) {
		getCooks().add(cook);
		cook.setWorkingTime(this);

		return cook;
	}

	public Cook removeCook(Cook cook) {
		getCooks().remove(cook);
		cook.setWorkingTime(null);

		return cook;
	}

}