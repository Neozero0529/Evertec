package com.evertec.store.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.store.persistence.entity.Order;
import com.evertec.store.persistence.repository.OrderRepository;
import com.evertec.store.service.OrderService;

@Service
public class BasicOrderService implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> read(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Order not availbele for Id :" + id));
	}

	@Override
	public Order create(Order e) {
		return e;
		
	}

	@Override
	public void update(Order e) {
		// TODO Auto-generated method stub
		
	}

}
