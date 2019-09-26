package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algorithms.CorporateActions;
import com.beans.Balance;
import com.beans.ClearingMember;
import com.beans.Rights;
import com.beans.Security;
import com.beans.Trade;

class CorporateActionsTest {
	
	List<Balance> balance = new ArrayList<Balance>();
	Security security;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Map<String, Integer> securityBalance = new HashMap<String, Integer>();
		securityBalance.put("Apple", 100);
		securityBalance.put("Walmart", 175);
		
		Balance b = new Balance();
		b.setFunds(10000);
		b.setSecurityBalance(securityBalance);
		
		Balance  obligation = new Balance();
		
		ArrayList<ClearingMember> clearingMembers  = new ArrayList<ClearingMember>();
		ArrayList<Trade> trade  = new ArrayList<Trade>();
		trade.add(new Trade(1,"Monday", "Apple", 2500,100,"GS","DB"));
		trade.add(new Trade(2,"Monday","GE",3000,45 ,"GS","GS"));
		trade.add(new Trade(3,"Monday","FB",500,154,"GS" ,"NT"));
		trade.add(new Trade(4,"Monday","FB",800 ,155 ,"DB","GS"));
		
		clearingMembers.add(new ClearingMember(1,"GS",b,obligation,trade,true,true));
		
		balance.add(clearingMembers.get(0).getBalance());
		
		security = new Security();
		security.setFaceValue(50);
		security.setMarketPrice(100);
		security.setSecurityName("Apple");
		
	}

	@Test
	void testIssueStockSplit() {
		CorporateActions action = new CorporateActions();
		
		balance = action.issueStockSplit(1.5, balance, "Apple");
		Map<String,Integer> security = balance.get(0).getSecurityBalance();
		
		assertEquals(150,security.get("Apple"));
	}
	
	@Test
	void testIssueStockSplitNegative() {
		CorporateActions action = new CorporateActions();
		
		balance = action.issueStockSplit(1.5, balance, "Apple");
		Map<String,Integer> security = balance.get(0).getSecurityBalance();

		assertEquals(175,security.get("Walmart"));
	}

	@Test
	void testIssueStockBonus() {
		CorporateActions action = new CorporateActions();
		
		balance = action.issueStockBonus(0.5, balance, "Apple");
		Map<String,Integer> security = balance.get(0).getSecurityBalance();
		
		assertEquals(150,security.get("Apple"));

	}
	
	@Test
	void testIssueStockBonusNegative() {
		CorporateActions action = new CorporateActions();
		
		balance = action.issueStockBonus(0.5, balance, "Apple");
		Map<String,Integer> security = balance.get(0).getSecurityBalance();

		assertEquals(175,security.get("Walmart"));

	}

	@Test
	void testIssueCashDividend() {
		
		CorporateActions action = new CorporateActions();
		
		balance = action.issueCashDividend(1.5, balance, security);
		double fund  = balance.get(0).getFunds();
		
		assertEquals(10075,fund);

	}
	
	@Test
	void testIssueCashDividendNegative() {
		
		CorporateActions action = new CorporateActions();
		
		security.setSecurityName("Linkedin");
		balance = action.issueCashDividend(1.5, balance, security);
		double fund  = balance.get(0).getFunds();
		
		assertEquals(10000,fund);

	}

	@Test
	void testIssueRights() {
		
		CorporateActions action = new CorporateActions();
		
		balance = action.issueRights(1.5, balance, 101.5, "Apple");
		double fund  = balance.get(0).getFunds();
		List<Rights> rights = balance.get(0).getRights();
		
		assertEquals(150,rights.get(0).getQuantity());

	}
	
	@Test
	void testIssueRightsNegative() {
		
		CorporateActions action = new CorporateActions();
		
		List<Rights> prevRights = balance.get(0).getRights();
		balance = action.issueRights(1.5, balance, 101.5, "Linkedin");
		double fund  = balance.get(0).getFunds();
		
		List<Rights> rights = balance.get(0).getRights();
		
		assertEquals(prevRights,rights);

	}
}
