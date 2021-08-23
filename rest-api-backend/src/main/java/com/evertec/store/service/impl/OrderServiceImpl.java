package com.evertec.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.store.dto.OrderDTO;
import com.evertec.store.mapper.OrderDTOMapper;
import com.evertec.store.mapper.OrderMapper;
import com.evertec.store.persistence.entity.Order;
import com.evertec.store.persistence.repository.OrderRepository;
import com.evertec.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderDTOMapper orderDTOMapper;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDTO> read() {		
		List<Order> orderList = orderRepository.findAll();
		List<OrderDTO> orderDTOList = new ArrayList<>();
		for (Order o : orderList) {
			orderDTOList.add(orderMapper.mapper(o));
		}
	
		return orderDTOList;
	}

	@Override
	public List<OrderDTO> read(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDTO read(Long id) {		
		return orderMapper.mapper(orderRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Order not available for Id :" + id)));				 
	}

	@Override
	public OrderDTO create(OrderDTO e) {		
		Order order = orderDTOMapper.mapper(e);
		order.setCreatedAt(new DateTime());
		return orderMapper.mapper(orderRepository.save(order)); 		
	}

	@Override
	public void update(OrderDTO e) {
		// TODO Auto-generated method stub
		
	}

	

}
