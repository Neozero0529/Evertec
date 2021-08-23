package com.evertec.store.exceptions.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evertec.store.config.Slf4jMDCFilterConfiguration;
import com.evertec.store.dto.ErrorDetailDTO;
import com.evertec.store.dto.ErrorDetailDTO.MessageCode;
import com.evertec.store.dto.ResponseDTO;
import com.evertec.store.dto.ResponseDTO.StatusCode;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InvalidDefinitionExceptionResolver {
	@ExceptionHandler(InvalidDefinitionException.class)
	public ResponseEntity<Object> handleMissingPathVariableException(HttpServletRequest request, HttpServletResponse response, InvalidDefinitionException ex) {		
		ResponseDTO error= new ResponseDTO(StatusCode.error,response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER));
    	error.getErrors().add(new ErrorDetailDTO(MessageCode.INVALID_DEFINITION, "Problem on your request.", ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}
