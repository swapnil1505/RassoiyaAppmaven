package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the wallet database table.
 * 
 */
@Entity
@NamedQuery(name="Wallet.findAll", query="SELECT w FROM Wallet w")
@EntityListeners(AuditingEntityListener.class)
public class Wallet extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wallet_id")
	private int walletId;

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