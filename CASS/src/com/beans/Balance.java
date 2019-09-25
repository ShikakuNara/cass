package com.beans;

import java.util.Map;

public class Balance {
	private int clearingMemberId;
	private double funds;
	private Map <String, Integer> securityBalance;
	private Rights rights;
	
	public Balance() {
		super();
	}

	public Balance(int clearingMemberId, double funds, Map<String, Integer> securityBalance, Rights rights) {
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

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "Balance [clearingMemberId=" + clearingMemberId + ", funds=" + funds + ", securityBalance="
				+ securityBalance + ", rights=" + rights + "]";
	}
	
}
