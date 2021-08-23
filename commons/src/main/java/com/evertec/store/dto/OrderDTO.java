package com.evertec.store.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class OrderDTO {		
	
	@Null
	private Long id;
		
	@NotBlank(message = "The customer name is required.")
	@Size(min = 3, max = 80, message = "The length of customer name must be between 3 and 80 characters.")
	private String customerName;
	
	@NotBlank(message = "The customer email is required.")
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", flags = { Flag.CASE_INSENSITIVE }, message = "The customer email is invalid.")
	@Size(min = 3, max = 120, message = "The length of customer email must be between 3 and 120 characters.")
	private String customerEmail;
			
	@NotBlank(message = "The customer mobile is required.")
	@Size(min = 3, max = 40, message = "The length of customer mobile must be between 3 and 40 characters.")
	private String customerMobile;
				
	private StatusOrderEnum status;			
	
	@Null	
	private DateTime  createdAt;
	
	@Null
	@JsonInclude(Include.NON_NULL)
	private DateTime  updatedAt;
	
	public OrderDTO() {}

	public OrderDTO(Long id, DateTime createdAt, DateTime updatedAt) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public OrderDTO(String customerName, String customerEmail, String customerMobile, StatusOrderEnum status) {
		super();		
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.status = status;		
	}		
	
}

