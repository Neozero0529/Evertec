package com.evertec.store.exceptions.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.evertec.store.config.Slf4jMDCFilterConfiguration;
import com.evertec.store.dto.ResponseDTO;
import com.evertec.store.dto.ErrorDetailDTO;
import com.evertec.store.dto.ErrorDetailDTO.MessageCode;
import com.evertec.store.dto.ResponseDTO.StatusCode;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NotFoundResourceExceptionResolver {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNotFoundResourceException(HttpServletRequest request, HttpServletResponse response, NoHandlerFoundException ex) {		
		ResponseDTO error= new ResponseDTO(StatusCode.error,response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER));
    	error.getErrors().add(new ErrorDetailDTO(MessageCode.NOT_FOUND_RESOURCE, "Requested resource wasn't found on the server", ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    
	}
}