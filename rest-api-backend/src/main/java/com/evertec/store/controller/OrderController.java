package com.evertec.store.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evertec.store.config.Slf4jMDCFilterConfiguration;
import com.evertec.store.dto.OrderDTO;
import com.evertec.store.dto.ResponseDTO;
import com.evertec.store.dto.ResponseDTO.StatusCode;
import com.evertec.store.persistence.entity.Order;
import com.evertec.store.persistence.repository.OrderRepository;
import com.evertec.store.service.OrderService;
import com.evertec.store.validator.OrderRequestValidator;

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
	public ResponseEntity<ResponseDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO, HttpServletResponse response) {
		logger.info("create order");
		OrderDTO order = orderService.create(orderDTO);
		
		ResponseDTO responseDTO = new ResponseDTO(StatusCode.success);
		responseDTO.setData(order);
		String requestId = response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER);
		if ( null != requestId) {
			responseDTO.setRequestId(requestId);
		}		
		return ResponseEntity.ok().body(responseDTO);		
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getOrderById(@PathVariable(value = "id") Long orderId,
			HttpServletResponse response) {
		logger.info("query order:" + orderId);
		OrderDTO order = orderService.read(orderId);
		
		ResponseDTO responseDTO = new ResponseDTO(StatusCode.success);
		responseDTO.setData(order);
		String requestId = response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER);
		if ( null != requestId) {
			responseDTO.setRequestId(requestId);
		}		
		return ResponseEntity.ok().body(responseDTO);
	}

	@GetMapping()
	public ResponseEntity<ResponseDTO> getAllOrders(HttpServletResponse response) {
		List<OrderDTO> order = orderService.read();
		ResponseDTO responseDTO = new ResponseDTO(StatusCode.success);
		responseDTO.setData(order);
		String requestId = response.getHeader(Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER);
		if ( null != requestId) {
			responseDTO.setRequestId(requestId);
		}
		return ResponseEntity.ok().body(responseDTO);	
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
