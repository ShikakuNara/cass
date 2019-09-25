package com.interfaces;

import java.util.List;

import com.beans.Balance;

public interface BalanceDao {
	public List<Balance> getAllBalances();
	public boolean updateAllBalances(List<Balance> balances);
	public Balance getBalanceByClearingMember(int clearingMemberId);
	public boolean updateSecurity(String securityName, int quantity, int clearingMemberId);
	public double updateFunds(double funds,int clearingMemberId);
}
