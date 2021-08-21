package com.evertec.store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorDetail {

    public static enum MessageCode {
        AUTHENTICATION, ENVIRONMENT, INPUT, RUNTIME, DATA;
    }

    private MessageCode code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private String detail;

    public ErrorDetail() {}

    public ErrorDetail(MessageCode code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public ErrorDetail(MessageCode code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.setDetail(detail);
    }

    public MessageCode getCode() { return this.code; }

    public void setCode(MessageCode code) { this.code = code; }

    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }

	public String getDetail() { return detail; }

	public void setDetail(String detail) { this.detail = detail; }

}

