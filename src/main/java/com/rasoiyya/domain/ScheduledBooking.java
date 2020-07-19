package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scheduled_booking database table.
 * 
 */
@Entity
@Table(name="scheduled_booking")
@NamedQuery(name="ScheduledBooking.findAll", query="SELECT s FROM ScheduledBooking s")
public class ScheduledBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private int bookingId;

	@Column(name="booking_type")
	private String bookingType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="scheduled_time")
	private Date scheduledTime;

	private String shift;

	//bi-directional one-to-one association to BookingDetail
	@OneToOne
	@JoinColumn(name="booking_id")
	private BookingDetail bookingDetail;

	public ScheduledBooking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return this.bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public Date getScheduledTime() {
		return this.scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getShift() {
		return this.shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public BookingDetail getBookingDetail() {
		return this.bookingDetail;
	}

	public void setBookingDetail(BookingDetail bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

}