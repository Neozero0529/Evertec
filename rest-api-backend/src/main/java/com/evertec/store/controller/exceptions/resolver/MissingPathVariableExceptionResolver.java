package com.evertec.store.controller.exceptions.resolver;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evertec.store.controller.exceptions.model.ErrorDetail;
import com.evertec.store.controller.exceptions.model.ErrorDetail.MessageCode;
import com.evertec.store.controller.exceptions.model.ErrorResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MissingPathVariableExceptionResolver {

	@ExceptionHandler(MissingPathVariableException.class)
	public ResponseEntity<Object> handleMissingPathVariableException(HttpServletRequest request, MissingPathVariableException ex) {		
		ErrorResponse error= new ErrorResponse(false, null, new Date());
    	error.getErrors().add(new ErrorDetail(MessageCode.RUNTIME, "Required path variable is missing in this request. Please add it to your request.", ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}