package com.cts.calculatenetworth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetSaleResponseTest {

	AssetSaleResponse asr1 = new AssetSaleResponse();
	AssetSaleResponse asr2 = new AssetSaleResponse(true,10330.00, null);
	
	
	@Test
	void setSaleStatusTest()
	{
		asr1.setSaleStatus(true);
		assertEquals(true, asr1.getSaleStatus());
	}
	
	@Test
	void setNetworthTest()
	{
		asr1.setNetworth(65000.50);
		assertEquals(65000.50, asr1.getNetworth());
	}
	
	
	@Test
	void setMapTest()
	{
		HashMap<String,Integer> map = new HashMap<>();
		map.put("ADANI GREEN", 18);
		
		asr1.setMap(map);
		assertEquals(map, asr1.getMap());
	}
	
	@Test
	void toStringTest()
	{
		assertEquals( "AssetSaleResponse(saleStatus=null, networth=null, map={})", asr1.toString());
	}
	
}
