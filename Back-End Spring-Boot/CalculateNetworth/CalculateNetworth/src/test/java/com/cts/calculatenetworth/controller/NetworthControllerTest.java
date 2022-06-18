package com.cts.calculatenetworth.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.calculatenetworth.feignclient.AuthorizationClient;
import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.model.PortfolioDetails;
import com.cts.calculatenetworth.model.StockDetail;
import com.cts.calculatenetworth.service.MutualFundService;
import com.cts.calculatenetworth.service.PortfolioDetailService;
import com.cts.calculatenetworth.service.StockDetailService;
import com.cts.calculatenetworth.vo.SaleDetailsVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(NetworthController.class)
class NetworthControllerTest {
	
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	@MockBean
	private PortfolioDetailService portfolioDetailService;
	@MockBean
	private AuthorizationClient authorizationClient;
	@MockBean
	private StockDetailService stockDetailService;
	@MockBean
	private MutualFundService mutualFundfolioDetailService;
    @Autowired
	private NetworthController networthController;

	MutualFund mutualFund = new MutualFund(21, "CPE", 10);
	StockDetail stockDetail = new StockDetail(10, "CTS", 10);


	@Test
	void testViewAsset() throws Exception {
		
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);
		
		PortfolioDetails portfolioDetails = new PortfolioDetails(101, sdList, mfList);

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		Mockito.when(portfolioDetailService.findByPfid(portfolioDetails.getPortfolioid())).thenReturn(portfolioDetails);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculateNetworth/viewAsset").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testCalculateNetworth() throws Exception {
		List<MutualFund> mfList = new ArrayList<>();
		mfList.add(mutualFund);
		List<StockDetail> sdList = new ArrayList<>();
		sdList.add(stockDetail);

		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "token");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculateNetworth/").headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	
	@Test
	void testSellingAsset() throws Exception
	{
		 List<SaleDetailsVO> saleDetailsList = new ArrayList<>();
		 saleDetailsList.add(new SaleDetailsVO("CTC", 9));
		 saleDetailsList.add(new SaleDetailsVO("TATA",3));
		 
		 Map<String, String> map = new HashMap<>();
	     map.put("Authorization", "token");
	     
	     HttpHeaders headers = new HttpHeaders();
	     headers.setAll(map);
	     
	     
	     this.networthController.sellingAssets(headers.toString(), saleDetailsList);
	}
	
	
	
	
	
	 public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
	 }
}