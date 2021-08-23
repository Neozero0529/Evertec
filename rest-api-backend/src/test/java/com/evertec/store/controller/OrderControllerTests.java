/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.evertec.store.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {
	
	private class OrderVO implements Serializable {		
		private static final long serialVersionUID = -7149190438168828801L;
		
		private String customer_id;
		private String deliveryAddress;
		private List<Integer> products;
		 
		public OrderVO(String customer_id, String deliveryAddress, List<Integer> products) {
			super();
			this.customer_id = customer_id;
			this.deliveryAddress = deliveryAddress;
			this.products = products;
		}		 	
	}

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void paramOrderShouldReturnAList() throws Exception {        
    	
        this.mockMvc.perform(get("/api/v1/order/list")
        		.param("customer", "1")
        		.param("start", "14/03/2021")
        		.param("end", "14/03/2021")).andDo(print()).andExpect(status().isOk())
        		.andExpect(jsonPath("$").isArray());
    }

    @Test
    public void createOrderFailByNotExpectedBody() throws Exception {

    	this.mockMvc.perform(put("/api/v1/order/create")
    		      .content(asJsonString(new OrderVO("1", "11001,BOGOTÁ, D.C.,Bogotá D.C.,KR 7 #26-20", Arrays.asList(10,10,15,18))))
    		      .contentType(MediaType.APPLICATION_JSON))    			  
    		      .andDo(print()).andExpect(status().isCreated());    		      
    }
    
    public static String asJsonString(final Object obj) {
        try {
        	ObjectMapper objectMapper = new ObjectMapper();
        	objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
