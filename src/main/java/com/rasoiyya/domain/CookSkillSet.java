package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cook_skill_set database table.
 * 
 */
@Entity
@Table(name="cook_skill_set")
@NamedQuery(name="CookSkillSet.findAll", query="SELECT c FROM CookSkillSet c")
public class CookSkillSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cook_skill_set_id")
	private int cookSkillSetId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Lob
	@Column(name="food_categories")
	private String foodCategories;

	@Lob
	@Column(name="food_type")
	private String foodType;

	@Lob
	private String languages;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="service_type")
	private String serviceType;

	//bi-directional many-to-one association to Cook
	@OneToMany(mappedBy="cookSkillSet")
	private List<Cook> cooks;

	public CookSkillSet() {
	}

	public int getCookSkillSetId() {
		return this.cookSkillSetId;
	}

	public void setCookSkillSetId(int cookSkillSetId) {
		this.cookSkillSetId = cookSkillSetId;
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

	public String getFoodCategories() {
		return this.foodCategories;
	}

	public void setFoodCategories(String foodCategories) {
		this.foodCategories = foodCategories;
	}

	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getLanguages() {
		return this.languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
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

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public List<Cook> getCooks() {
		return this.cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public Cook addCook(Cook cook) {
		getCooks().add(cook);
		cook.setCookSkillSet(this);

		return cook;
	}

	public Cook removeCook(Cook cook) {
		getCooks().remove(cook);
		cook.setCookSkillSet(null);

		return cook;
	}

}