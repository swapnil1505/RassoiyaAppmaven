package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the offer database table.
 * 
 */
@Entity
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
@EntityListeners(AuditingEntityListener.class)
public class Offer extends Auditable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="offer_id")
	private int offerId;

	private String occasion;

	@Lob
	@Column(name="offer_details")
	private String offerDetails;

	@Temporal(TemporalType.DATE)
	@Column(name="offer_end_date")
	private Date offerEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="offer_start_date")
	private Date offerStartDate;

	@Column(name="offer_type")
	private String offerType;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="offer")
	private List<Notification> notifications;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOccasion() {
		return this.occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getOfferDetails() {
		return this.offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public Date getOfferEndDate() {
		return this.offerEndDate;
	}

	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
	}

	public Date getOfferStartDate() {
		return this.offerStartDate;
	}

	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public String getOfferType() {
		return this.offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setOffer(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setOffer(null);

		return notification;
	}

}