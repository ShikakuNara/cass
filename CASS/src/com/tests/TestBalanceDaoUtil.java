package com.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.beans.Balance;
import com.dao.BalanceDaoUtil;

public class TestBalanceDaoUtil {
	
	@Test 
	public void testUpdateFunds() {
		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		double actual = baldaoutil.updateFunds(2453, 1);
		assertEquals(2453, actual);
		double funds = baldaoutil.updateFunds(248850, 1);
	}

	@Test
	public void testGetAllBalances() {
		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		List<Balance> balances = new ArrayList<Balance>();
		balances = baldaoutil.getAllBalances();
		assertEquals(6, balances.size());
		Balance actual = balances.get(0);
		assertEquals(6, balances.size());
		assertEquals(1, actual.getClearingMemberId());
		assertEquals(248850, actual.getFunds());
		Map<String, Integer> secbal = new HashMap<String, Integer>();
		secbal.put("Facebook", 3351);
		secbal.put("LinkedIn", 4697);
		secbal.put("GE", 4768);
		secbal.put("Walmart", 	1577);
		secbal.put("Apple", 402);
		//System.out.println("secBal:" + actual.getSecurityBalance());
		//System.out.println("secbal1:"+ secbal);
		
		//assertEquals(secbal, actual.getSecurityBalance());
		
		
	}
	

	@Test
	public void testgetBalanceByClearingMember() {
		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		Balance actual = baldaoutil.getBalanceByClearingMember(2);
		Map<String, Integer> secbal = new HashMap<String, Integer>();
		secbal.put("Facebook", 1834);
		secbal.put("LinkedIn", 2112);
		secbal.put("GE", 4044);
		secbal.put("Walmart", 	3708);
		secbal.put("Apple", 719);
		assertEquals(495366, actual.getFunds());
		assertEquals(secbal, actual.getSecurityBalance());
	}
	

	@Test
	public void testAllUpdateBalancesbySecurities() {

		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		
		boolean actual = false;
		List<Balance> balances = baldaoutil.getAllBalances();
		//int stock = balances.get(0).getSecurityBalance().put("Apple", 4556);
		Map<String, Integer> secbal = new HashMap<String, Integer>();
		secbal.put("Apple", 100);
		secbal.put("Facebook", 130);
		secbal.put("LinkedIn", 120);
		secbal.put("GE", 110);
		secbal.put("Walmart", 157);
		//balances.get(0).setSecurityBalance(secbal);
		actual = baldaoutil.updateAllBalancesBySecurity(balances, "Facebook");
		assertEquals(true, actual);
		System.out.println("test: "+baldaoutil.getAllBalances().get(0).getSecurityBalance());
	
		//Map<String, Integer> secbal2 = new HashMap<String, Integer>();
		secbal.put("Apple", 402);
		secbal.put("Facebook", 3351);
		secbal.put("LinkedIn", 4697);
		secbal.put("GE", 4768);
		secbal.put("Walmart", 1577);
		baldaoutil.getAllBalances().get(0).setSecurityBalance(secbal);
	}
	

	@Test
	public void testUpdateSecurity() {
		boolean actual = false;
		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		Balance balance = new Balance();
		balance.setClearingMemberId(1);
		balance.setFunds(248850);
		Map<String, Integer> secbal = new HashMap<String, Integer>();
		secbal.put("Apple", 4);
		secbal.put("Facebook", 3351);
		secbal.put("LinkedIn", 4697);
		secbal.put("GE", 4768);
		secbal.put("Walmart", 1577);
		balance.setSecurityBalance(secbal);
		//System.out.println(secbal);
		balance.setSecurityBalance(secbal);
		actual = baldaoutil.updateSecurity(balance);
		//System.out.println("secbalupdated: "+ baldaoutil.getAllBalances());
		assertEquals(true, actual);
		secbal.put("Apple", 402);
		balance.setSecurityBalance(secbal);
		baldaoutil.updateSecurity(balance);
		
	}
	
	@Test
	public void testUpdateAllFunds() 
	{
		BalanceDaoUtil baldaoutil = new BalanceDaoUtil();
		List<Balance> balances = new ArrayList<Balance>();
		balances = baldaoutil.getAllBalances();
		boolean actual = false;
		balances.get(0).setFunds(12345);
		balances.get(1).setFunds(2346);
		balances.get(2).setFunds(9);
		balances.get(3).setFunds(5678);
		balances.get(4).setFunds(9887);
		actual = baldaoutil.updateFundBalance(balances);
		assertEquals(true, actual);
		assertEquals(12345, baldaoutil.getAllBalances().get(0).getFunds());
		balances.get(0).setFunds(248850);
		balances.get(1).setFunds(495366);
		balances.get(2).setFunds(853148);
		balances.get(3).setFunds(288780);
		balances.get(4).setFunds(648456);
		baldaoutil.updateFundBalance(balances);
		
		
		
	}

}
