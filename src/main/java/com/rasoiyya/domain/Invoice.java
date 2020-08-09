package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
@EntityListeners(AuditingEntityListener.class)
public class Invoice extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_id")
	private int invoiceId;

	@Column(name="cook_service_type")
	private String cookServiceType;

	@Column(name="is_invoice_sent")
	private String isInvoiceSent;

	@Column(name="number_of_days")
	private int numberOfDays;

	@Column(name="tot_amt")
	private double totAmt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="work_duration")
	private Date workDuration;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Cook
	@ManyToOne
	@JoinColumn(name="cook_id")
	private Cook cook;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="invoice")
	private List<Payment> payments;

	public Invoice() {
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getCookServiceType() {
		return this.cookServiceType;
	}

	public void setCookServiceType(String cookServiceType) {
		this.cookServiceType = cookServiceType;
	}

	public String getIsInvoiceSent() {
		return this.isInvoiceSent;
	}

	public void setIsInvoiceSent(String isInvoiceSent) {
		this.isInvoiceSent = isInvoiceSent;
	}

	public int getNumberOfDays() {
		return this.numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public double getTotAmt() {
		return this.totAmt;
	}

	public void setTotAmt(double totAmt) {
		this.totAmt = totAmt;
	}

	public Date getWorkDuration() {
		return this.workDuration;
	}

	public void setWorkDuration(Date workDuration) {
		this.workDuration = workDuration;
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

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setInvoice(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setInvoice(null);

		return payment;
	}

}