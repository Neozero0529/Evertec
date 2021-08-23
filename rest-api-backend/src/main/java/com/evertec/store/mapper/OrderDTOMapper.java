package com.evertec.store.mapper;

import org.springframework.stereotype.Component;

import com.evertec.store.dto.OrderDTO;
import com.evertec.store.persistence.entity.Order;

@Component
public class OrderDTOMapper implements ModelMapper<Order, OrderDTO>{

	@Override
	public Order mapper(OrderDTO entity) {
		Order order = new Order()				       
	        .setCustomerName(entity.getCustomerName())
	        .setCustomerEmail(entity.getCustomerEmail())
	        .setCustomerMobile(entity.getCustomerMobile())
	        .setStatus(entity.getStatus());	        	
		return order;
		  
	}

}
