package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.Balance;
import com.interfaces.BalanceDao;

public class ObligationBalanceDaoUtil implements BalanceDao{

	@Override
	public List<Balance> getAllBalances() {
		List<Balance> balances = new ArrayList<Balance>();
		
		String SQL_GET_ALL_BALANCE = "SELECT * FROM ObligationBalances";
		
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL_BALANCE);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Balance balance = new Balance();
				int clearingMemberId = rs.getInt("clearingMemberId");
				balance.setClearingMemberId(clearingMemberId);
				balance.setFunds(rs.getDouble("funds"));
				Map<String, Integer> securityBalance = new HashMap<>();
				securityBalance.put("Facebook", rs.getInt("facebook"));
				securityBalance.put("LinkedIn", rs.getInt("linkedin"));
				securityBalance.put("GE", rs.getInt("ge"));
				securityBalance.put("Apple", rs.getInt("apple"));
				securityBalance.put("Walmart", rs.getInt("walmart"));
				balance.setSecurityBalance(securityBalance);
				
				balances.add(balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return balances;
	}

	@Override
	public boolean updateAllBalances(List<Balance> balances) {
		boolean isUpdated = false;
		String SQL_UPDATE_BALANCES = "UPDATE balances SET funds=?,facebook=?,linkedin=?,ge=?,walmart=?,apple=? WHERE clearingMemberId=?";
		
		try(Connection conn = DBConnection.openConnection()){
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_BALANCES);
			
			for(Balance balance : balances) {
				ps.setDouble(1, balance.getFunds());
				ps.setInt(2, balance.getSecurityBalance().get("facebook"));
				ps.setInt(3, balance.getSecurityBalance().get("linkedin"));
				ps.setInt(4, balance.getSecurityBalance().get("ge"));
				ps.setInt(5, balance.getSecurityBalance().get("walmart"));
				ps.setInt(6, balance.getSecurityBalance().get("apple"));
				ps.setInt(7, balance.getClearingMemberId());
				
				ps.addBatch();
			}
			int[] rs = ps.executeBatch();
			
			if(rs.length == 6) {
				isUpdated = true;
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
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
		
	//Not useful
	@Override
	public boolean updateSecurity(String securityName, int quantity, int clearingMemberId) {
		return false;
	}

	@Override
	public double updateFunds(double funds, int clearingMemberId) {
		return 0;
	}

	@Override
	public boolean updateAllBalancesBySecurity(List<Balance> balances, String securityName) {
		return false;
	}

}
