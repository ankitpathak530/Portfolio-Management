package com.cts.calculatenetworth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PortfolioDetailsTest {

	PortfolioDetails pd = new PortfolioDetails();
	
	@Test
	void setPortfolioIdTest() {
		pd.setPortfolioid(101);
		assertEquals(101, pd.getPortfolioid());
	}
	
	@Test
	void setStockDetailsListTest() {
		pd.setStockDetailList(null);
		
		assertEquals(null, pd.getStockDetailList());
	}
	
	
	@Test
	void setMutualFundList() {
		pd.setMutualFundList(null);
		assertEquals(null, pd.getMutualFundList());
	}
	
	
	
}
