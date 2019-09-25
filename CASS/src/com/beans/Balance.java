package com.beans;

import java.util.Map;

public class Balance {
	private int id;
	private double fundBalance;
	private Map <String, Integer> securityBalance;
	private Rights rights;
	public Balance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Balance(int id, double fundBalance, Map<String, Integer> securityBalance, Rights rights) {
		super();
		this.id = id;
		this.fundBalance = fundBalance;
		this.securityBalance = securityBalance;
		this.rights = rights;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getFundBalance() {
		return fundBalance;
	}
	public void setFundBalance(double fundBalance) {
		this.fundBalance = fundBalance;
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
		return "Balance [id=" + id + ", fundBalance=" + fundBalance + ", securityBalance=" + securityBalance
				+ ", rights=" + rights + "]";
	}
}
