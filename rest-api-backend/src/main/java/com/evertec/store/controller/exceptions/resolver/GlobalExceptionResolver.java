package com.evertec.store.controller.exceptions.resolver;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evertec.store.controller.exceptions.model.ErrorDetail;
import com.evertec.store.controller.exceptions.model.ErrorDetail.MessageCode;
import com.evertec.store.controller.exceptions.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>  handleException(HttpServletRequest request, Exception ex) {
    	ErrorResponse error= new ErrorResponse(false, null, new Date());
    	error.getErrors().add(new ErrorDetail(MessageCode.RUNTIME, ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    	       
    }

}