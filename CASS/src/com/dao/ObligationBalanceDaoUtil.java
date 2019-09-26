package com.dao;

import java.util.List;

import com.beans.Balance;
import com.interfaces.BalanceDao;

public class ObligationBalanceDaoUtil implements BalanceDao{

	@Override
	public List<Balance> getAllBalances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAllBalances(List<Balance> balances) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Balance getBalanceByClearingMember(int clearingMemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSecurity(String securityName, int quantity, int clearingMemberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double updateFunds(double funds, int clearingMemberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
