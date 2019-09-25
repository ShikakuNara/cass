package com.beans;

public class Trade {
	
	private int tradeId;
	private String day;
	private String securityName;
	private int quantity;
	private double price;
	private String buyer;
	private String seller;
	
	public Trade() {
		super();
	}
	
	public Trade(int tradeId, String day, String securityName, int quantity, double price, String buyer,
			String seller) {
		super();
		this.tradeId = tradeId;
		this.day = day;
		this.securityName = securityName;
		this.quantity = quantity;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
	}
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", day=" + day + ", securityName=" + securityName + ", quantity="
				+ quantity + ", price=" + price + ", buyer=" + buyer + ", seller=" + seller + "]";
	}
}
