package com.cts.calculatenetworth.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaleDetailsVOTest {
	
	SaleDetailsVO sd1 = new SaleDetailsVO();
	SaleDetailsVO sd2 = new SaleDetailsVO("CTC",18);
	
	@Test
	void setAssetNameTest()
	{
		sd1.setAssetName("ADANI GREEN");
		sd1.setSoldUnits(12);
		assertEquals("ADANI GREEN", sd1.getAssetName());
	}
	
	@Test
	void setAssetUnitTest()
	{
		sd1.setAssetName("ADANI GREEN");
		sd1.setSoldUnits(12);
		assertEquals(12, sd1.getSoldUnits());
	}

	@Test
	void toStringTest()
	{
		sd1.setAssetName("ADANI GREEN");
		sd1.setSoldUnits(18);
		assertEquals("SaleDetailsVO(assetName=ADANI GREEN, soldUnits=18)", sd1.toString());
	}
}
