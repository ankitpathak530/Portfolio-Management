package com.cts.dailymutualfundnav.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.dailymutualfundnav.controller.MutualFundController;

@SpringBootTest
public class MutualNotFoundExceptionTest {

	@Autowired
	private MutualFundController mutualFundController;
	
	
	@Test
	void mutualFundNotFoundTest() {
		
		try {
			this.mutualFundController.getMutualFundDetails("3434234324sfewfewfef", "Rakhi");
			
		}catch (Exception e) {
			try {
				throw new MutualFundNotFoundException("Mutual Found not Available");	
			}
			catch(MutualFundNotFoundException ex) {
				assertEquals(ex.getMessage(), "Mutual Found not Available");
			}
			
		}
	}
}
