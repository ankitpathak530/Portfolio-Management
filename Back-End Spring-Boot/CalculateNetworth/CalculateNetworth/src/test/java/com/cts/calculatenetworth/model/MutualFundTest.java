package com.cts.calculatenetworth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MutualFundTest {

	
	MutualFund mf = new MutualFund();
	MutualFund mf1 = new MutualFund(10, "CTE", 12);

	@Test
	void testGetMutualFundId() {
		mf.setMfId(10);
		assertEquals(10, mf.getMfId());
	}

	@Test
	void testGetMutualFundName() {
		mf.setMutualFundName("GGE");
		assertEquals("GGE", mf.getMutualFundName());
	}


	@Test
	void testToString() {
		MutualFund mf = new MutualFund(11, "abc", 1000);
		assertEquals("MutualFund(mfId=11, mutualFundName=abc, mutualFundUnits=1000, portfolioDetails=null)", mf.toString());
	}
	
	@Test
	void testConstructor()
	{
		MutualFund mf = new MutualFund(1,null,1,null);
		mf.setPortfolioDetails(null);
		assertEquals(null, mf.getPortfolioDetails());
	}
}
