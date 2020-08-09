package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the booking_details database table.
 * 
 */
@Entity
@Table(name="booking_details")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
@EntityListeners(AuditingEntityListener.class)
public class BookingDetail extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private int bookingId;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_end_date")
	private Date bookingEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_start_date")
	private Date bookingStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="booking_time")
	private Date bookingTime;

	@Column(name="booking_type")
	private String bookingType;

	@Column(name="evening_time_slot")
	private Time eveningTimeSlot;

	@Column(name="food_category")
	private String foodCategory;

	@Column(name="food_expectatons")
	private String foodExpectatons;

	@Column(name="food_type")
	private String foodType;

	@Column(name="morning_time_slot")
	private Time morningTimeSlot;

	@Column(name="no_of_person")
	private int noOfPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="schedulded_time")
	private Date scheduldedTime;

	private String tenure;

	//bi-directional one-to-one association to ActiveBooking
	@OneToOne(mappedBy="bookingDetail")
	private ActiveBooking activeBooking;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name="payment_id")
	private Payment payment;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Cook
	@ManyToOne
	@JoinColumn(name="cook_id")
	private Cook cook;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="customer_address_id")
	private Address address;

	//bi-directional one-to-one association to ScheduledBooking
	@OneToOne(mappedBy="bookingDetail")
	private ScheduledBooking scheduledBooking;

	public BookingDetail() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingEndDate() {
		return this.bookingEndDate;
	}

	public void setBookingEndDate(Date bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public Date getBookingStartDate() {
		return this.bookingStartDate;
	}

	public void setBookingStartDate(Date bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public Date getBookingTime() {
		return this.bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getBookingType() {
		return this.bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public Time getEveningTimeSlot() {
		return this.eveningTimeSlot;
	}

	public void setEveningTimeSlot(Time eveningTimeSlot) {
		this.eveningTimeSlot = eveningTimeSlot;
	}

	public String getFoodCategory() {
		return this.foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getFoodExpectatons() {
		return this.foodExpectatons;
	}

	public void setFoodExpectatons(String foodExpectatons) {
		this.foodExpectatons = foodExpectatons;
	}

	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Time getMorningTimeSlot() {
		return this.morningTimeSlot;
	}

	public void setMorningTimeSlot(Time morningTimeSlot) {
		this.morningTimeSlot = morningTimeSlot;
	}

	public int getNoOfPerson() {
		return this.noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public Date getScheduldedTime() {
		return this.scheduldedTime;
	}

	public void setScheduldedTime(Date scheduldedTime) {
		this.scheduldedTime = scheduldedTime;
	}

	public String getTenure() {
		return this.tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public ActiveBooking getActiveBooking() {
		return this.activeBooking;
	}

	public void setActiveBooking(ActiveBooking activeBooking) {
		this.activeBooking = activeBooking;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cook getCook() {
		return this.cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ScheduledBooking getScheduledBooking() {
		return this.scheduledBooking;
	}

	public void setScheduledBooking(ScheduledBooking scheduledBooking) {
		this.scheduledBooking = scheduledBooking;
	}

}