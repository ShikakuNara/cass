package com.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balance {
	private int clearingMemberId;
	private double funds;
	private Map <String, Integer> securityBalance;
	private List<Rights> rights;
	
	public Balance() {
		super();
		clearingMemberId = 0;
		funds = 0;
		securityBalance = new HashMap<String, Integer>();
		rights  = new ArrayList<Rights>();
	}

	public Balance(int clearingMemberId, double funds, Map<String, Integer> securityBalance, List<Rights> rights) {
		super();
		this.clearingMemberId = clearingMemberId;
		this.funds = funds;
		this.securityBalance = securityBalance;
		this.rights = rights;
	}

	public int getClearingMemberId() {
		return clearingMemberId;
	}

	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public Map<String, Integer> getSecurityBalance() {
		return securityBalance;
	}

	public void setSecurityBalance(Map<String, Integer> securityBalance) {
		this.securityBalance = securityBalance;
	}

	public List<Rights> getRights() {
		return rights;
	}

	public void setRights(List<Rights> rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "Balance [clearingMemberId=" + clearingMemberId + ", funds=" + funds + ", securityBalance="
				+ securityBalance + ", rights=" + rights + "]";
	}
	
}
