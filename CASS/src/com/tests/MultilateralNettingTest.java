package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algorithms.MultiLateralNetting;
import com.beans.Balance;
import com.beans.ClearingMember;
import com.beans.Trade;

class MultilateralNettingTest {

	MultiLateralNetting multiNet = null;
	List<ClearingMember> clearingMembers = null;

	@BeforeEach
	private void setup() {
		 multiNet = new MultiLateralNetting();
		clearingMembers = new ArrayList<ClearingMember>();

		

		ArrayList<Trade> trade = new ArrayList<Trade>();
		trade.add(new Trade(1, "Monday", "Apple", 2500, 100, "GS", "DB"));
		trade.add(new Trade(1, "Monday", "GE", 3000, 45, "GS", "GS"));
		trade.add(new Trade(1, "Monday", "FB", 500, 154, "GS", "NT"));
		trade.add(new Trade(1, "Monday", "FB", 800, 155, "DB", "GS"));
		clearingMembers.add(new ClearingMember(1, "GS", new Balance(), new Balance(), trade, true, true));

		ArrayList<Trade> trade1 = new ArrayList<Trade>();
		trade1.add(new Trade(1, "Monday", "Apple", 2500, 100, "GS", "DB"));
		trade1.add(new Trade(1, "Monday", "GE", 3500, 44, "Citi", "DB"));
		trade1.add(new Trade(1, "Monday", "FB", 2000, 155, "NT", "DB"));   
		trade1.add(new Trade(1, "Monday", "FB", 800, 155, "DB", "GS"));
		trade1.add(new Trade(1, "Monday", "Walmart", 4200, 78, "DB", "NT"));
		clearingMembers.add(new ClearingMember(2, "DB", new Balance(), new Balance(), trade1, true, true));
		
		ArrayList<Trade> trade2 = new ArrayList<Trade>();
		trade2.add(new Trade(1, "Monday", "Apple", 12000, 101, "JP", "Citi"));
		trade2.add(new Trade(1, "Monday", "LI", 5500, 102, "DB", "JP"));
		trade2.add(new Trade(1, "Monday", "Walmart", 1500, 77, "Citi", "JP"));
		trade2.add(new Trade(1, "Monday", "LI", 3400, 103, "JP", "Citi"));
		clearingMembers.add(new ClearingMember(10,"JP",new Balance(),new Balance(),trade2,true,true));
		
		ArrayList<Trade> trade3 = new ArrayList<Trade>();
		trade3.add(new Trade(1, "Monday", "Walmart", 1500, 77, "Citi", "JP"));
		trade3.add(new Trade(1, "Monday", "LI", 3400, 103, "JP", "Citi"));
		trade3.add(new Trade(1, "Monday", "Apple", 12000, 101, "JP", "Citi"));
		trade3.add(new Trade(1, "Monday", "GE", 3500, 44, "Citi", "DB"));
		trade3.add(new Trade(1, "Monday", "Apple", 250, 100, "NT", "Citi"));
		 clearingMembers.add(new ClearingMember(1,"Citi",new Balance(),new Balance(),trade3,true,true));
		
		ArrayList<Trade> trade4 = new ArrayList<Trade>();
		trade4.add(new Trade(1, "Monday", "Apple", 250, 100, "NT", "Citi"));
		trade4.add(new Trade(1, "Monday", "Walmart", 4200, 78, "DB", "NT"));
		trade4.add(new Trade(1, "Monday", "FB", 2000, 155, "NT", "DB"));
		trade4.add(new Trade(1, "Monday", "FB", 500, 154, "GS", "NT"));
		 clearingMembers.add(new ClearingMember(1,"NT",new Balance(),new Balance(),trade4,true,true));
//		System.out.println(clearingMembers.get(0));
	}

	@Test
	void testCalculateFundObligation() {

		List<Balance> updatedClearingMember = multiNet.calculateFundObligation(clearingMembers);
		 assertEquals(203000,updatedClearingMember.get(0).getFunds());
		assertEquals(-1317700.0, updatedClearingMember.get(3).getFunds());
     	assertEquals(-262400, updatedClearingMember.get(1).getFunds());
		 assertEquals(885700,updatedClearingMember.get(2).getFunds());
		assertEquals(-69600,updatedClearingMember.get(4).getFunds());
	}

	@Test
	void testCalculateSecurityObligation() {
		Map<String, Integer> security = new HashMap<String, Integer>();
		security.put("Apple", -2500);
		security.put("FB", 300);
		security.put("GE", 0);
		assertEquals(security, multiNet.calculateSecurityObligation(clearingMembers).get(0).getObligationBalance()
				.getSecurityBalance());

	}

}
