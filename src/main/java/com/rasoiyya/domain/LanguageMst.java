package com.rasoiyya.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the language_mst database table.
 * 
 */
@Entity
@Table(name="language_mst")
@NamedQuery(name="LanguageMst.findAll", query="SELECT l FROM LanguageMst l")
public class LanguageMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="language_id")
	private int languageId;

	private String language;

	@Column(name="language_code")
	private int languageCode;

	public LanguageMst() {
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLanguageCode() {
		return this.languageCode;
	}

	public void setLanguageCode(int languageCode) {
		this.languageCode = languageCode;
	}

}