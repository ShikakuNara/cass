package com.tests;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.beans.Trade;
import com.dao.TradeDaoUtil;

class TestTradeDaoUtil {


	@Test
	final void testGetAllTrades() {
	    TradeDaoUtil tdu = new TradeDaoUtil();
		List<Trade> actual = tdu.getAllTrades();
		assertEquals(120, actual.size());
		Trade trade = actual.get(2);
		assertEquals(3, actual.get(2).getTradeId());
		assertEquals("Citi", actual.get(2).getBuyer());
		assertEquals("CreditSuisse", actual.get(2).getSeller());
		assertEquals(1410, actual.get(2).getQuantity());
		assertEquals(146.41423483326798, actual.get(2).getPrice(), 0.0);
		
		
		
	}

	@Test
	final void testGetTradesByClearingMember() {
		TradeDaoUtil tdu = new TradeDaoUtil();
		List<Trade> actual = tdu.getTradesByClearingMember(1);
		assertEquals(45, actual.size());
		assertEquals(3, actual.get(2).getTradeId());
		assertEquals("Citi", actual.get(2).getBuyer());
		assertEquals("CreditSuisse", actual.get(2).getSeller());
		assertEquals(1410, actual.get(2).getQuantity());
		assertEquals(146.41423483326798, actual.get(2).getPrice(), 0.0);
	}

	@Test
	final void testGetTrade() {
		TradeDaoUtil tdu = new TradeDaoUtil();
		Trade actual = tdu.getTrade(3);
		assertEquals("Citi", actual.getBuyer());
		assertEquals("CreditSuisse", actual.getSeller());
		assertEquals(1410, actual.getQuantity());
		assertEquals(146.41423483326798, actual.getPrice(), 0.0);
	}

	@Test
	final void testUpdateTrade() {
		
	}

	@Test
	final void testDeleteTrade() {
		
	}

	@Test
	final void testAddTrade() {
	
	}

}
