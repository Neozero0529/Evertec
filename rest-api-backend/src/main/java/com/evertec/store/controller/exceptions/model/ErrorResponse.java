package com.evertec.store.controller.exceptions.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorResponse {
	
	private boolean success;
	@JsonInclude(Include.NON_NULL)
	private String requestId;	
	private Date timestamp;	
	private List<ErrorDetail> errors;

	public ErrorResponse() {
		
	}	
	
	public ErrorResponse(boolean success, String requestId, Date timestamp) {
		super();
		this.success = success;
		this.requestId = requestId;
		this.timestamp = timestamp;		
	}
	
	public ErrorResponse(boolean success, String requestId, Date timestamp, List<ErrorDetail> errors) {
		super();
		this.success = success;
		this.requestId = requestId;
		this.timestamp = timestamp;
		this.setErrors(errors);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<ErrorDetail> getErrors() {
		if ( null == errors){
			errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}
}
