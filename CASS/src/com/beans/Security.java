package com.beans;

public class Security {
	
	private String securityName;
	private double marketPrice;
	private double faceValue;
	private double interestRate;
	
	public Security() {
		super();
	}
	
	public Security(String securityName, double marketPrice, double faceValue, double interestRate) {
		super();
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.faceValue = faceValue;
		this.interestRate = interestRate;
	}
	
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "Security [securityName=" + securityName + ", marketPrice=" + marketPrice + ", faceValue=" + faceValue
				+ ", interestRate=" + interestRate + "]";
	}
}
