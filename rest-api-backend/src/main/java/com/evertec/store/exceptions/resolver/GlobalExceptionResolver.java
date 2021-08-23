package com.evertec.store.exceptions.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evertec.store.config.Slf4jMDCFilterConfiguration;
import com.evertec.store.dto.ResponseDTO;
import com.evertec.store.dto.ResponseDTO.StatusCode;
import com.evertec.store.dto.ErrorDetailDTO;
import com.evertec.store.dto.ErrorDetailDTO.MessageCode;

@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>  handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
    	ResponseDTO error= new ResponseDTO(StatusCode.error,response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER));
    	error.getErrors().add(new ErrorDetailDTO(MessageCode.RUNTIME, ex.getMessage()));
	    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);    	       
    }

}