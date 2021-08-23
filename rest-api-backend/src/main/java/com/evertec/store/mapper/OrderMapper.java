package com.evertec.store.mapper;

import org.springframework.stereotype.Component;

import com.evertec.store.dto.OrderDTO;
import com.evertec.store.persistence.entity.Order;

@Component
public class OrderMapper implements ModelMapper<OrderDTO, Order>{	
	
	public OrderMapper() {}

	@Override
	public OrderDTO mapper(Order entity) {
		OrderDTO orderDTO = new OrderDTO(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt())
		.setStatus(entity.getStatus())	
		.setCustomerName(entity.getCustomerName())
		.setCustomerEmail(entity.getCustomerEmail())
		.setCustomerMobile(entity.getCustomerMobile());		
		return orderDTO;
	}

}
