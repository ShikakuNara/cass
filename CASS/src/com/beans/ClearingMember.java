package com.beans;

import java.util.List;

public class ClearingMember {
	
	private int clearingMemberID;
	private String clearingMemberName;
	Balance balance;
	Balance obligationBalance;
	List<Trade> trades;
	boolean isSubmitted;
	boolean isReportGenerated;
	
	public ClearingMember() {
		super();
	}
	
	public ClearingMember(int clearingMemberID, String clearingMemberName, Balance balance, Balance obligationBalance,
			List<Trade> trades, boolean isSubmitted, boolean isReportGenerated) {
		super();
		this.clearingMemberID = clearingMemberID;
		this.clearingMemberName = clearingMemberName;
		this.balance = balance;
		this.obligationBalance = obligationBalance;
		this.trades = trades;
		this.isSubmitted = isSubmitted;
		this.isReportGenerated = isReportGenerated;
	}

	public int getClearingMemberID() {
		return clearingMemberID;
	}
	public void setClearingMemberID(int clearingMemberID) {
		this.clearingMemberID = clearingMemberID;
	}
	public String getClearingMemberName() {
		return clearingMemberName;
	}
	public void setClearingMemberName(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
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
	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
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
		return "ClearingMember [clearingMemberID=" + clearingMemberID + ", clearingMemberName=" + clearingMemberName
				+ ", balance=" + balance + ", obligationBalance=" + obligationBalance + ", trades=" + trades
				+ ", isSubmitted=" + isSubmitted + ", isReportGenerated=" + isReportGenerated + "]";
	}
}
