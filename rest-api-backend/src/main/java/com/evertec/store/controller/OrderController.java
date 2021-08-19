package com.evertec.store.controller;

import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertec.store.rest.validator.OrderRequestValidator;


@Consumes("application/json")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);        	

    @Autowired
    private OrderRequestValidator orderRequestValidator;
 
	@InitBinder(value = "orderRequest")
    void initOrderRequestValidator(WebDataBinder binder) {
        binder.setValidator(orderRequestValidator);
    }	
	
	@PostMapping()
    public String createOrder(){
		return "create order";	
	}
	
	@GetMapping()
    public String getOrder(){
		return "get order";
	}
	
	@PutMapping()
    public String updateOrder(){
		return "update order";	
	}		
	
	@DeleteMapping()
    public String deleteOrder(){
		return "delete order";	
	}
           
}
