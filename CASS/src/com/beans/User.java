package com.beans;

public class User {
	public enum Role{
		CM,CH,ADMIN;
	}
	private String username;
	private String password;
	private Role role;
	private int clearingMemberId;
	
	public User() {
		super();
	}
	public User(String username, String password, Role role, int clearingMemberId) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.clearingMemberId = clearingMemberId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getClearingMemberId() {
		return clearingMemberId;
	}
	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", clearingMemberId="
				+ clearingMemberId + "]";
	}
}
