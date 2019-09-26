package com.beans;

public class Rights {
	
	private int rightsId;
	private double marketPrice;
	private String securityName;
	private int quantity;
	
	public Rights() {
		super();
	}
	
	public Rights(int rightsId, double marketPrice, String securityName, int quantity) {
		super();
		this.rightsId = rightsId;
		this.marketPrice = marketPrice;
		this.securityName = securityName;
		this.quantity = quantity;
	}

	public int getRightsId() {
		return rightsId;
	}

	public void setRightsId(int rightsId) {
		this.rightsId = rightsId;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Rights [rightsId=" + rightsId + ", marketPrice=" + marketPrice + ", securityName=" + securityName
				+ ", quantity=" + quantity + "]";
	}

}
