package com.evertec.store.controller.exceptions.resolver;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.evertec.store.controller.exceptions.model.ErrorDetail;
import com.evertec.store.controller.exceptions.model.ErrorDetail.MessageCode;
import com.evertec.store.controller.exceptions.model.ErrorResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NotFoundResourceExceptionResolver {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNotFoundResourceException(HttpServletRequest request, NoHandlerFoundException ex) {		
		ErrorResponse error= new ErrorResponse(false, null, new Date());
    	error.getErrors().add(new ErrorDetail(MessageCode.RUNTIME, "Requested resource wasn't found on the server", ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    
	}
}