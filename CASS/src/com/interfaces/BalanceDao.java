package com.interfaces;

import java.util.List;

import com.beans.Balance;

public interface BalanceDao {
	public List<Balance> getAllBalances();
	public boolean updateAllBalances(List<Balance> balances);
	public boolean updateAllBalancesBySecurity(List<Balance> balances, String securityName);
	public Balance getBalanceByClearingMember(int clearingMemberId);
	public boolean updateSecurity(Balance balance);
	public double updateFunds(double funds,int clearingMemberId);
	public boolean updateFundBalance(List<Balance> balances);
}
