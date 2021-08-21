package com.evertec.store.repository;


	
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.evertec.store.persistence.entity.Order;
import com.evertec.store.service.impl.BasicOrderService;

@SpringBootTest()
public class OrderTest {
	
	private BasicOrderService orderService = new BasicOrderService();

	@Test	
	@DisplayName("╯°□°）╯")
	public void test() {		
		 Order order = new Order();
		 order.setCustomerEmail("manuelosorio@email.edu.co"); 
		 order.setCustomerMobile("321321123");
		 order.setCustomerName("manuel osorio"); 
		 order.setCreatedAt(new DateTime());
		 Order orderCreated = orderService.create(order);
		 
		 assertTrue(orderCreated != null);
	}
}
