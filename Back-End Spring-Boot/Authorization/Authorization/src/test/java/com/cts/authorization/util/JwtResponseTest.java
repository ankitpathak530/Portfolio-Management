package com.cts.authorization.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JwtResponseTest {

	
	@Test
	void testGetterSetterToString() {
		JwtResponse jwtResponse = new JwtResponse("e12dkfdfdfkd");
		
		assertEquals("e12dkfdfdfkd",jwtResponse.getJwttoken());
		
		jwtResponse.setJwttoken("eetdvgferef");
		assertEquals("eetdvgferef",jwtResponse.getJwttoken());
		
		assertEquals(jwtResponse.toString(),jwtResponse.toString());
	
	}
	

}
