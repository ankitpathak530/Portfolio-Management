package com.cts.calculatenetworth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockDetailsTest {

	
	StockDetail st  = new StockDetail();
	StockDetail st1 = new StockDetail(11, "MRX", 12);
	StockDetail tt1 = new StockDetail(102,"def",122,null);
	
	
	
	@Test
	void testGetStockId() {
		st.setStId(12);;
		assertEquals(12, st.getStId());
	}

	@Test
	void testGetStockName() {
		st.setStockName("CRS");
		assertEquals("CRS", st.getStockName());
	}

	@Test
	void testGetStockCount() {
		st.setStockCount(15);
		assertEquals(15, st.getStockCount());
		
	}

	@Test
	void testSetStockPortfolio() {
		st.setPortfolioDetails(null);
		assertEquals(null, st.getPortfolioDetails());
	}


	@Test
	void testToString() {
		StockDetail st= new StockDetail(101, "abc", 100);
		assertEquals("StockDetail(stId=101, stockName=abc, stockCount=100, portfolioDetails=null)",st.toString());

	}
}
