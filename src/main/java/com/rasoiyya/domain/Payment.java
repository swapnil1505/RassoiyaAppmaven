package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@EntityListeners(AuditingEntityListener.class)
public class Payment extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_id")
	private int paymentId;

	@Column(name="admin_shared_amt")
	private double adminSharedAmt;

	@Column(name="cook_received_amt")
	private double cookReceivedAmt;

	@Column(name="payment_mode")
	private String paymentMode;

	@Column(name="tot_amt_transferred")
	private double totAmtTransferred;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	@Column(name="transaction_number")
	private String transactionNumber;

	@Column(name="transaction_status")
	private String transactionStatus;

	//bi-directional many-to-one association to BookingDetail
	@OneToMany(mappedBy="payment")
	private List<BookingDetail> bookingDetails;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Cook
	@ManyToOne
	@JoinColumn(name="cook_id")
	private Cook cook;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAdminSharedAmt() {
		return this.adminSharedAmt;
	}

	public void setAdminSharedAmt(double adminSharedAmt) {
		this.adminSharedAmt = adminSharedAmt;
	}

	public double getCookReceivedAmt() {
		return this.cookReceivedAmt;
	}

	public void setCookReceivedAmt(double cookReceivedAmt) {
		this.cookReceivedAmt = cookReceivedAmt;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getTotAmtTransferred() {
		return this.totAmtTransferred;
	}

	public void setTotAmtTransferred(double totAmtTransferred) {
		this.totAmtTransferred = totAmtTransferred;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getTransactionStatus() {
		return this.transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public List<BookingDetail> getBookingDetails() {
		return this.bookingDetails;
	}

	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().add(bookingDetail);
		bookingDetail.setPayment(this);

		return bookingDetail;
	}

	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().remove(bookingDetail);
		bookingDetail.setPayment(null);

		return bookingDetail;
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

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}