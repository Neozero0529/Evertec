package com.evertec.store.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.evertec.store.dto.StatusOrderEnum;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
@Data
@Accessors(chain = true)
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(name="customer_name", nullable = false)
	@Size(min = 3, max = 80)
	private String customerName;
			
	@Column(name="customer_email", nullable = false)
	@Size(min = 3, max = 120)
	private String customerEmail;
			
	@Column(name="customer_mobile", nullable = false)
	@Size(min = 3, max = 40)
	private String customerMobile;
				
	@Enumerated(EnumType.STRING)
	@Column(name="status",columnDefinition = "enum('CREATED','PAYED','REJECTED')", nullable = false)
	@Size(min = 3, max = 20)
	private StatusOrderEnum status;
			
	//@CreationTimestamp with datatime joda annotation does not work 
	@Column(name="created_at", nullable = false)
	private DateTime  createdAt;
	
	//@UpdateTimestamp with datatime joda annotation does not work 
	@Column(name="updated_at")
	private DateTime  updatedAt;	
   
}
