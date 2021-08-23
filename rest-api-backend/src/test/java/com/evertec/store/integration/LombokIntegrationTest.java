package com.evertec.store.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.Setter;

public class LombokIntegrationTest {
	@Test
    public void givenAnnotatedOrder_thenHasGettersAndSetters() {
        User user = new User();
        user.setFirstName("Test");
        assertEquals(user.getFirstName(), "Test");
    }

    @Getter @Setter
    class User {
        private String firstName;
    }
}
