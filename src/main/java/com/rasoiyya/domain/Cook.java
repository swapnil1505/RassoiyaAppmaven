package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cook database table.
 * 
 */
@Entity
@NamedQuery(name="Cook.findAll", query="SELECT c FROM Cook c")
@EntityListeners(AuditingEntityListener.class)
public class Cook extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cook_id")
	private int cookId;

	@Column(name="kyc_status")
	private String kycStatus;

	//bi-directional many-to-one association to BookingDetail
	@OneToMany(mappedBy="cook")
	private List<BookingDetail> bookingDetails;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	//bi-directional many-to-one association to CookSkillSet
	@ManyToOne
	@JoinColumn(name="cook_skill_set_id")
	private CookSkillSet cookSkillSet;

	//bi-directional many-to-one association to WorkingTime
	@ManyToOne
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="cook")
	private List<Document> documents;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="cook")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Geo
	@OneToMany(mappedBy="cook")
	private List<Geo> geos;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="cook")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="cook")
	private List<Payment> payments;

	public Cook() {
	}

	public int getCookId() {
		return this.cookId;
	}

	public void setCookId(int cookId) {
		this.cookId = cookId;
	}

	public String getKycStatus() {
		return this.kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public List<BookingDetail> getBookingDetails() {
		return this.bookingDetails;
	}

	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().add(bookingDetail);
		bookingDetail.setCook(this);

		return bookingDetail;
	}

	public BookingDetail removeBookingDetail(BookingDetail bookingDetail) {
		getBookingDetails().remove(bookingDetail);
		bookingDetail.setCook(null);

		return bookingDetail;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CookSkillSet getCookSkillSet() {
		return this.cookSkillSet;
	}

	public void setCookSkillSet(CookSkillSet cookSkillSet) {
		this.cookSkillSet = cookSkillSet;
	}

	public WorkingTime getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(WorkingTime workingTime) {
		this.workingTime = workingTime;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setCook(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setCook(null);

		return document;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setCook(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setCook(null);

		return feedback;
	}

	public List<Geo> getGeos() {
		return this.geos;
	}

	public void setGeos(List<Geo> geos) {
		this.geos = geos;
	}

	public Geo addGeo(Geo geo) {
		getGeos().add(geo);
		geo.setCook(this);

		return geo;
	}

	public Geo removeGeo(Geo geo) {
		getGeos().remove(geo);
		geo.setCook(null);

		return geo;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setCook(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setCook(null);

		return invoice;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setCook(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setCook(null);

		return payment;
	}

}