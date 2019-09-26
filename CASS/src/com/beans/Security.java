package com.beans;

public class Security {
	private int id;
	private String securityName;
	private double faceValue;
	private double interestRate;
	private double price;

	public Security(double faceValue, int id, int quantity, String securityName, double interest, double price) {
		super();
		this.id = id;
		this.securityName = securityName;
		this.faceValue = faceValue;
		this.interestRate = interest;  
		this.price = price;
	}
	public Security() {
		id = 0;
		securityName = "";
		faceValue = 0;
		interestRate = 0;
		price = 0;
	}

	public double getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public double getInterest() {
		return interestRate;
	}
	public void setInterest(double interest) {
		this.interestRate = interest;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Security [faceValue=" + faceValue + ", id=" + id + ", securityName=" + securityName + ", interest="
				+ interestRate + ", price=" + price + "]";
	}
}
