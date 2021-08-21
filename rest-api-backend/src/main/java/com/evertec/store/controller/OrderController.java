package com.evertec.store.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evertec.store.persistence.entity.Order;
import com.evertec.store.persistence.repository.OrderRepository;
import com.evertec.store.rest.validator.OrderRequestValidator;
import com.evertec.store.service.OrderService;

@RestController
@RequestMapping(path = "/order", 
consumes = MediaType.APPLICATION_JSON_VALUE, 
produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	


	@Autowired
	private OrderService orderService;

//	@InitBinder(value = "orderRequest")
//	void initOrderRequestValidator(WebDataBinder binder) {
//		binder.setValidator(orderRequestValidator);
//	}


	@PostMapping()
	public String createOrder() {
		return "create order";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId) {
		logger.info("query order:" + orderId);
		Order order = orderService.read(orderId);
		return ResponseEntity.ok().body(order);
	}

	@GetMapping()
	public List<Order> getAllOrders() {
		return  orderService.read();		
	}

	@PutMapping()
	public String updateOrder() {
		return "update order";
	}

	@DeleteMapping()
	public String deleteOrder() {
		return "delete order";
	}

}
