package com.evertec.store.controller.exceptions.resolver;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evertec.store.config.Slf4jMDCFilterConfiguration;
import com.evertec.store.controller.exceptions.model.ErrorDetail;
import com.evertec.store.controller.exceptions.model.ErrorDetail.MessageCode;
import com.evertec.store.controller.exceptions.model.ErrorResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NoSuchElementExceptionResolver {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request, HttpServletResponse response, NoSuchElementException ex) {		
		ErrorResponse error= new ErrorResponse(false,response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER));
    	error.getErrors().add(new ErrorDetail(MessageCode.DATA, ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    
	}
}
