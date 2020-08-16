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

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}