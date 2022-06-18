package com.cts.calculatenetworth.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MutualFundVOTest {

	
	MutualFundVO mf = new MutualFundVO();
	MutualFundVO mf1 = new MutualFundVO(10, "CTE", 12);

	@Test
	void testGetMutualFundId() {
		mf.setMutualFundId(10);
		assertEquals(10, mf.getMutualFundId());
	}

	@Test
	void testGetMutualFundName() {
		mf.setMutualFundName("GGE");
		assertEquals("GGE", mf.getMutualFundName());
	}

	@Test
	void testGetMutualFundValue() {
		mf.setMutualFundValue(12);
		assertEquals(12, mf.getMutualFundValue());
	}

	@Test
	void testSetMutualFundId() {
		mf.setMutualFundId(11);
		assertEquals(11, mf.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mf.setMutualFundName("GGE");
		assertEquals("GGE", mf.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mf.setMutualFundValue(12);
		assertEquals(12, mf.getMutualFundValue());
	}

	@Test
	void testToString() {
		MutualFundVO mf = new MutualFundVO(11, "abc", 100.0);
		assertEquals("MutualFundVO(mutualFundId=11, mutualFundName=abc, mutualFundValue=100.0)", mf.toString());
	}
}
