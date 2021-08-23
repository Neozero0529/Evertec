package com.evertec.store.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorDTO {
	
	private boolean success;
	@JsonInclude(Include.NON_NULL)
	private String requestId;	
	private DateTime timestamp;
	@JsonInclude(Include.NON_NULL)
	private List<ErrorDetail> errors;

	public ErrorDTO() {
		
	}
	
	public ErrorDTO(boolean success) {
		super();
		this.success = success;		
		this.timestamp = new DateTime();		
	}
	
	public ErrorDTO(boolean success, String requestId) {
		super();
		this.success = success;
		this.requestId = requestId;
		this.timestamp = new DateTime();		
	}
	
	public ErrorDTO(boolean success, String requestId, DateTime timestamp) {
		super();
		this.success = success;
		this.requestId = requestId;
		this.timestamp = timestamp;		
	}
	
	public ErrorDTO(boolean success, String requestId, DateTime timestamp, List<ErrorDetail> errors) {
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

	public DateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(DateTime timestamp) {
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
