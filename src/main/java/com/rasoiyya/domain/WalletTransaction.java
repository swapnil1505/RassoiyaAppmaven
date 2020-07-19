package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the wallet_transaction database table.
 * 
 */
@Entity
@Table(name="wallet_transaction")
@NamedQuery(name="WalletTransaction.findAll", query="SELECT w FROM WalletTransaction w")
public class WalletTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wallet_transaction_id")
	private int walletTransactionId;

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

	@Column(name="payment_mode")
	private String paymentMode;

	@Column(name="transaction_amt")
	private double transactionAmt;

	@Column(name="transaction_id")
	private String transactionId;

	//bi-directional many-to-one association to Wallet
	@OneToMany(mappedBy="walletTransaction")
	private List<Wallet> wallets;

	public WalletTransaction() {
	}

	public int getWalletTransactionId() {
		return this.walletTransactionId;
	}

	public void setWalletTransactionId(int walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
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

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getTransactionAmt() {
		return this.transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public List<Wallet> getWallets() {
		return this.wallets;
	}

	public void setWallets(List<Wallet> wallets) {
		this.wallets = wallets;
	}

	public Wallet addWallet(Wallet wallet) {
		getWallets().add(wallet);
		wallet.setWalletTransaction(this);

		return wallet;
	}

	public Wallet removeWallet(Wallet wallet) {
		getWallets().remove(wallet);
		wallet.setWalletTransaction(null);

		return wallet;
	}

}