package com.evertec.store.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ResponseDTO {
	
	public static enum StatusCode {
        success, fail, error;
    }
	
	private StatusCode status;
	@JsonInclude(Include.NON_NULL)
	private String requestId;	
	private DateTime timestamp;
	@JsonInclude(Include.NON_EMPTY)
	private List<ErrorDetailDTO> errors = new ArrayList<>();
	@JsonInclude(Include.NON_NULL)
	Object data;	
	
	public ResponseDTO() {}
	
	public ResponseDTO(StatusCode success) {
		super();
		this.status = success;		
		this.timestamp = new DateTime();		
	}
	
	public ResponseDTO(StatusCode success, String requestId) {
		super();
		this.status = success;
		this.requestId = requestId;
		this.timestamp = new DateTime();		
	}
	
	public ResponseDTO(StatusCode success, String requestId, DateTime timestamp) {
		super();
		this.status = success;
		this.requestId = requestId;
		this.timestamp = timestamp;		
	}
	
	public ResponseDTO(StatusCode success, String requestId, DateTime timestamp, List<ErrorDetailDTO> errors) {
		super();
		this.status = success;
		this.requestId = requestId;
		this.timestamp = timestamp;
		this.setErrors(errors);
	}		
	
}
