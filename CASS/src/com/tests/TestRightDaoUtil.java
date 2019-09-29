package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.beans.Rights;
import com.dao.RightDaoUtil;

class TestRightDaoUtil {

	@Test
	final void testAddRight() {
		RightDaoUtil rightdaoutil = new RightDaoUtil();
		Rights rights = new Rights();
		//rights = Rights(12,123, "Apple", 12)
		//rights.setRightsId(1);
		rights.setMarketPrice(245);
		rights.setQuantity(12);
		rights.setSecurityName("Apple");
		System.out.println(rights);
		int cmid = 1;
		//int actual = 0;
		int actual = rightdaoutil.addRight(rights, 1);
		System.out.println("actual: "+actual);
		assertEquals(1, actual);
	}

	@Test
	final void testUpdateQuantity() {
		RightDaoUtil rightdaoutil = new RightDaoUtil();
		int actual = rightdaoutil.updateQuantity(1, 13, "Apple");
		assertEquals(2, actual);
	}

	@Test
	final void testGetRightsByClearingMember() {
		RightDaoUtil rightdaoutil = new RightDaoUtil();
		List<Rights> actual = rightdaoutil.getRightsByClearingMember(2);
		List<Rights> rights = new ArrayList<Rights>();
		Rights right = new Rights(2,234,"Apple",56); 
		rights.add(right);
		//System.out.println("actual:" + actual);
		assertEquals(rights.get(0).getMarketPrice(), actual.get(0).getMarketPrice());
		assertEquals(rights.size(), actual.size());
		assertEquals(rights.get(0).getRightsId(), actual.get(0).getRightsId());
		
	}

}
