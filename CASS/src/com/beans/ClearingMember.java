package com.beans;

import java.util.ArrayList;

public class ClearingMember {
	
	private int id;
	private String name;
	Balance balance;
	Balance obligationBalance;
	ArrayList<Trade> trade;
	boolean isSubmitted;
	boolean isReportGenerated;
	
	public ClearingMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClearingMember(int id, String name, Balance balance, Balance obligationBalance, ArrayList<Trade> trade,
			boolean isSubmitted, boolean isReportGenerated) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.obligationBalance = obligationBalance;
		this.trade = trade;
		this.isSubmitted = isSubmitted;
		this.isReportGenerated = isReportGenerated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Balance getObligationBalance() {
		return obligationBalance;
	}

	public void setObligationBalance(Balance obligationBalance) {
		this.obligationBalance = obligationBalance;
	}

	public ArrayList<Trade> getTrade() {
		return trade;
	}

	public void setTrade(ArrayList<Trade> trade) {
		this.trade = trade;
	}

	public boolean isSubmitted() {
		return isSubmitted;
	}

	public void setSubmitted(boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	public boolean isReportGenerated() {
		return isReportGenerated;
	}

	public void setReportGenerated(boolean isReportGenerated) {
		this.isReportGenerated = isReportGenerated;
	}

	@Override
	public String toString() {
		return "ClearingMember [id=" + id + ", name=" + name + ", balance=" + balance + ", obligationBalance="
				+ obligationBalance + ", trade=" + trade + ", isSubmitted=" + isSubmitted + ", isReportGenerated="
				+ isReportGenerated + "]";
	}

}
