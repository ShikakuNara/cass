package com.tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import com.beans.Security;
import com.dao.SecurityDaoUtil;

class TestSecurityDaoUtilTest {

	@Test
	final void testGetNameById() {
		SecurityDaoUtil sdu = new SecurityDaoUtil();
		String actual = sdu.getNameById(2);
		assertEquals("GE", actual);
	}

	@Test
	final void testGetIdByName() {
		SecurityDaoUtil sdu = new SecurityDaoUtil();
		int actual = sdu.getIdByName("GE");
		assertEquals(2, actual);
	
	}

	@Test
	final void testGetSecurityByName() {
		SecurityDaoUtil sdu = new SecurityDaoUtil();
		Security security = sdu.getSecurityByName("GE");
		assertEquals(security.getSecurityName(), "GE");
		assertEquals(security.getInterestRate(), 8);
		assertEquals(security.getMarketPrice(), 152.49694392650733);
		assertEquals(security.getFaceValue(), 153.06069645290574 );
		
	
	}

}
