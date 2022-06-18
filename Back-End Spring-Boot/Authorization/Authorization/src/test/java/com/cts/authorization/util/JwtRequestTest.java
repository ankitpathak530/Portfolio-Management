package com.cts.authorization.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JwtRequestTest {

	
	@Test
	void testGetterSetter() {
		JwtRequest jwtRequest = new JwtRequest();
		
		jwtRequest.setUsername("Ankit");
		jwtRequest.setPassword("1234");
		
		assertEquals("Ankit",jwtRequest.getUsername());
		assertEquals("1234",jwtRequest.getPassword());
	
		assertEquals(jwtRequest.toString(),jwtRequest.toString());

		
	}
	

}
