package com.evertec.store.exceptions.resolver;

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
import com.evertec.store.dto.ErrorDTO;
import com.evertec.store.dto.ErrorDetail;
import com.evertec.store.dto.ErrorDetail.MessageCode;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NoSuchElementExceptionResolver {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request, HttpServletResponse response, NoSuchElementException ex) {		
		ErrorDTO error= new ErrorDTO(false,response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER));
    	error.getErrors().add(new ErrorDetail(MessageCode.DATA, ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    
	}
}
