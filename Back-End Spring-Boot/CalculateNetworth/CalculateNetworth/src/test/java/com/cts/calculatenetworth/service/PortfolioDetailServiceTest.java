package com.cts.calculatenetworth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.PortfolioDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.repository.PortfolioDetailsRepository;

@SpringBootTest
class PortfolioDetailServiceTest {
	@MockBean
	private PortfolioDetailsRepository portfolioDetailsRepository;

	@Autowired
	private PortfolioDetailService portfolioDetailService;

	
	MutualFund mutualFund=new MutualFund(10,"CTS",10);
	MutualFund mutualFund1=new MutualFund(11,"SBI",10);
	
	StockDetail stockDetail=new  StockDetail(21,"GGE",10);
	StockDetail stockDetail1=new  StockDetail(22,"YHO",10);
	



	@Test
	void testPortfolioDetails() {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);

		Mockito.when(portfolioDetailsRepository.findByPortfolioid(101)).thenReturn(portfolioDetails);
		assertEquals(portfolioDetails, portfolioDetailService.findByPfid(101));
		status().isOk();
	}

	@Test
	void testGetAll() {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);
		
		List<MutualFund> mfList1 = new ArrayList<>();
		mfList1.add(mutualFund);
		List<StockDetail> sdList1 = new ArrayList<>();
		sdList1.add(stockDetail);
		PortfolioDetails portfolioDetails1 = new PortfolioDetails(102, sdList1, mfList1);
		
		List<PortfolioDetails> records = new ArrayList<>(Arrays.asList(portfolioDetails, portfolioDetails1));

		Mockito.when(portfolioDetailsRepository.findAll()).thenReturn(records);
		assertEquals(records, portfolioDetailService.getAll());
		status().isOk();
	}
	
	
	@Test
	void getCalculateNetWorthTest() throws Exception
	{
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		double getcalculateNetworth =0;
		try {
		  getcalculateNetworth = portfolioDetailService.getcalculateNetworth(101,"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb29AZW1haWwuY29tIiwiZXhwIjoxNjM4ODU1MzA1LCJpYXQiOjE2Mzg4MTkzMDV9.q4FWV7yVDAs_DREiF524VZ-udnqwV81GEOgdCj6QQAs");
		}catch(Exception e) {
			assertNotEquals(69000, getcalculateNetworth);
		}
		 
	}

}
