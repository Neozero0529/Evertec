package com.evertec.store.repository;


	
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.evertec.store.dto.OrderDTO;
import com.evertec.store.service.OrderService;
import com.evertec.store.service.impl.OrderServiceImpl;

@SpringBootTest()
public class OrderTest {
	
	private OrderService orderService = new OrderServiceImpl();

	@Test	
	@DisplayName("╯°□°）╯")
	public void test() {		
		 OrderDTO order = new OrderDTO();
		 order.setCustomerEmail("manuelosorio@email.edu.co"); 
		 order.setCustomerMobile("321321123");
		 order.setCustomerName("manuel osorio"); 		 
		 OrderDTO orderCreated = orderService.create(order);
		 
		 assertTrue(orderCreated != null);
	}
}
