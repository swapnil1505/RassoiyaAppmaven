package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the geo database table.
 * 
 */
@Entity
@NamedQuery(name="Geo.findAll", query="SELECT g FROM Geo g")
public class Geo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_id")
	private int geoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	private String latitude;

	private String longitude;

	//bi-directional many-to-one association to Cook
	@ManyToOne
	@JoinColumn(name="cook_id")
	private Cook cook;

	public Geo() {
	}

	public int getGeoId() {
		return this.geoId;
	}

	public void setGeoId(int geoId) {
		this.geoId = geoId;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Cook getCook() {
		return this.cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

}