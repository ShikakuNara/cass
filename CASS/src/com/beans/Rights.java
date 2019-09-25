package com.beans;

public class Rights {
	
	private int id;
	private double price;
	private String securityName;
	private int quantity;
	

	public Rights() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rights(int id,double price, String securityName, int quantity) {
		super();
		this.id = id;
		this.price = price;
		this.securityName = securityName;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
		return "Rights [id=" + id + ", price=" + price + ", securityName=" + securityName + ", quantity=" + quantity
				+ "]";
	}

}
