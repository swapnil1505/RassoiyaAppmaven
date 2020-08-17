package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@EntityListeners(AuditingEntityListener.class)
public class Customer extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int customerId;

	//bi-directional many-to-one association to BookingDetail
//	@OneToMany(mappedBy="customer")
//	private List<BookingDetail> bookingDetails;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	//bi-directional many-to-one association to Feedback
//	@OneToMany(mappedBy="customer")
//	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Invoice
//	@OneToMany(mappedBy="customer")
//	private List<Invoice> invoices;

	//bi-directional many-to-one association to Payment
//	@OneToMany(mappedBy="customer")
//	private List<Payment> payments;

	//bi-directional many-to-one association to Wallet
//	@OneToMany(mappedBy="customer")
//	private List<Wallet> wallets;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

//	public List<BookingDetail> getBookingDetails() {
//		return this.bookingDetails;
//	}
//
//	public void setBookingDetails(List<BookingDetail> bookingDetails) {
//		this.bookingDetails = bookingDetails;
//	}
//
//	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
//		getBookingDetails().add(bookingDetail);
//		bookingDetail.setCustomer(this);
//
//		return bookingDetail;
//	}
//
//	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
//		getBookingDetails().remove(bookingDetail);
//		bookingDetail.setCustomer(null);
//
//		return bookingDetail;
//	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

//	public List<Feedback> getFeedbacks() {
//		return this.feedbacks;
//	}
//
//	public void setFeedbacks(List<Feedback> feedbacks) {
//		this.feedbacks = feedbacks;
//	}
//
//	public Feedback addFeedback(Feedback feedback) {
//		getFeedbacks().add(feedback);
//		feedback.setCustomer(this);
//
//		return feedback;
//	}
//
//	public Feedback removeFeedback(Feedback feedback) {
//		getFeedbacks().remove(feedback);
//		feedback.setCustomer(null);
//
//		return feedback;
//	}
//
//	public List<Invoice> getInvoices() {
//		return this.invoices;
//	}
//
//	public void setInvoices(List<Invoice> invoices) {
//		this.invoices = invoices;
//	}
//
//	public Invoice addInvoice(Invoice invoice) {
//		getInvoices().add(invoice);
//		invoice.setCustomer(this);
//
//		return invoice;
//	}
//
//	public Invoice removeInvoice(Invoice invoice) {
//		getInvoices().remove(invoice);
//		invoice.setCustomer(null);
//
//		return invoice;
//	}
//
//	public List<Payment> getPayments() {
//		return this.payments;
//	}
//
//	public void setPayments(List<Payment> payments) {
//		this.payments = payments;
//	}
//
//	public Payment addPayment(Payment payment) {
//		getPayments().add(payment);
//		payment.setCustomer(this);
//
//		return payment;
//	}
//
//	public Payment removePayment(Payment payment) {
//		getPayments().remove(payment);
//		payment.setCustomer(null);
//
//		return payment;
//	}
//
//	public List<Wallet> getWallets() {
//		return this.wallets;
//	}
//
//	public void setWallets(List<Wallet> wallets) {
//		this.wallets = wallets;
//	}
//
//	public Wallet addWallet(Wallet wallet) {
//		getWallets().add(wallet);
//		wallet.setCustomer(this);
//
//		return wallet;
//	}
//
//	public Wallet removeWallet(Wallet wallet) {
//		getWallets().remove(wallet);
//		wallet.setCustomer(null);
//
//		return wallet;
//	}

}