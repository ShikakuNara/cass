package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Balance balance = new Balance();
		
		String SQL_GET_BALANCE_BY_ID = "SELECT * FROM ObligationBalances WHERE clearingMemberId=?";
		
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_BALANCE_BY_ID);
			
			ps.setInt(1, clearingMemberId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				balance.setClearingMemberId(rs.getInt("clearingMemberId"));
				balance.setFunds(rs.getDouble("funds"));
				Map<String, Integer> securityBalance = new HashMap<>();
				securityBalance.put("Facebook", rs.getInt("facebook"));
				securityBalance.put("LinkedIn", rs.getInt("linkedin"));
				securityBalance.put("GE", rs.getInt("ge"));
				securityBalance.put("Apple", rs.getInt("apple"));
				securityBalance.put("Walmart", rs.getInt("walmart"));
				balance.setSecurityBalance(securityBalance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
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
