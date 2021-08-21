package com.evertec.store.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@Column(name="customer_name")
	@Size(min = 3, max = 80)
	private String customerName;
		
	@NotNull
	@Column(name="customer_email")
	@Size(min = 3, max = 120)
	private String customerEmail;
		
	@NotNull
	@Column(name="customer_mobile")
	@Size(min = 3, max = 40)
	private String customerMobile;
		
	@NotNull
	@Column(name="status")
	@Size(min = 3, max = 20)
	private String status;
	
	@NotNull
	@Column(name="created_at")
	private DateTime  createdAt;
	
	@Column(name="updated_at")
	private DateTime  updatedAt;
	
	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
   
}
