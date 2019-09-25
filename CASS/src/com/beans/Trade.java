package com.beans;

public class Trade {
	
	private int id;
	private String day;
	private String securityName;
	private int quantity;
	private double price;
	private String buyer;
	private String seller;
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trade(int id, String day, String securityName, int quantity, double price, String buyer, String seller) {
		super();
		this.id = id;
		this.day = day;
		this.securityName = securityName;
		this.quantity = quantity;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", day=" + day + ", securityName=" + securityName + ", quantity=" + quantity
				+ ", price=" + price + ", buyer=" + buyer + ", seller=" + seller + "]";
	}

}
