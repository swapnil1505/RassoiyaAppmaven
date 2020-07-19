package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wallet database table.
 * 
 */
@Entity
@NamedQuery(name="Wallet.findAll", query="SELECT w FROM Wallet w")
public class Wallet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wallet_id")
	private int walletId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="wallet_amt")
	private String walletAmt;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to WalletTransaction
	@ManyToOne
	@JoinColumn(name="wallet_transaction_id")
	private WalletTransaction walletTransaction;

	public Wallet() {
	}

	public int getWalletId() {
		return this.walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getWalletAmt() {
		return this.walletAmt;
	}

	public void setWalletAmt(String walletAmt) {
		this.walletAmt = walletAmt;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public WalletTransaction getWalletTransaction() {
		return this.walletTransaction;
	}

	public void setWalletTransaction(WalletTransaction walletTransaction) {
		this.walletTransaction = walletTransaction;
	}

}