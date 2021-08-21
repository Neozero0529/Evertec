package com.evertec.store.dto;

import org.joda.time.DateTime;


public class OrderDTO extends ErrorDTO {
		
	private Long id;
		
	private String customerName;
	
	private String customerEmail;
			
	private String customerMobile;
			
	private String status;
		
	private DateTime  createdAt;
		
	private DateTime  updatedAt;	
	
}
