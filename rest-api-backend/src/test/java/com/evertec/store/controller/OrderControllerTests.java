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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.evertec.store.dto.OrderDTO;
import com.evertec.store.dto.StatusOrderEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void paramOrderShouldReturnAList() throws Exception {        
    	
        this.mockMvc.perform(get("/api/v1/order"))
        		.andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void createOrderFailByNotExpectedBody() throws Exception {
    	this.mockMvc.perform(post("/api/v1/order")
    		      .content(asJsonString(new OrderDTO("camilo osorio","camilo.osorio@gmail.com","321221221",StatusOrderEnum.CREATED)))
    		      .contentType(MediaType.APPLICATION_JSON))    			  
    		      .andDo(print()).andExpect(status().isOk());    		      
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
