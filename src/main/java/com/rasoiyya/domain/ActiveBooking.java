package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the active_booking database table.
 * 
 */
@Entity
@Table(name="active_booking")
@NamedQuery(name="ActiveBooking.findAll", query="SELECT a FROM ActiveBooking a")
@EntityListeners(AuditingEntityListener.class)
public class ActiveBooking extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private int bookingId;

	@Column(name="food_made")
	private String foodMade;

	@Column(name="is_absent")
	private String isAbsent;

	private String shift;

	@Column(name="time_taken")
	private Time timeTaken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="visit_end_time")
	private Date visitEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="visit_start_time")
	private Date visitStartTime;

	//bi-directional one-to-one association to BookingDetail
	@OneToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	public ActiveBooking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getFoodMade() {
		return this.foodMade;
	}

	public void setFoodMade(String foodMade) {
		this.foodMade = foodMade;
	}

	public String getIsAbsent() {
		return this.isAbsent;
	}

	public void setIsAbsent(String isAbsent) {
		this.isAbsent = isAbsent;
	}

	public String getShift() {
		return this.shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Time getTimeTaken() {
		return this.timeTaken;
	}

	public void setTimeTaken(Time timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Date getVisitEndTime() {
		return this.visitEndTime;
	}

	public void setVisitEndTime(Date visitEndTime) {
		this.visitEndTime = visitEndTime;
	}

	public Date getVisitStartTime() {
		return this.visitStartTime;
	}

	public void setVisitStartTime(Date visitStartTime) {
		this.visitStartTime = visitStartTime;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

}