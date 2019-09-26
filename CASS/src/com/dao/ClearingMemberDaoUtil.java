package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Balance;
import com.beans.ClearingMember;
import com.beans.Trade;
import com.interfaces.ClearingMemberDao;

public class ClearingMemberDaoUtil implements ClearingMemberDao{

	public List<ClearingMember> getAllClearingMembers() {
		
		List<ClearingMember> clearingMembers = new ArrayList<ClearingMember>();
		TradeDaoUtil tradeDao = new TradeDaoUtil();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		ObligationBalanceDaoUtil obligationBalanceDao = new ObligationBalanceDaoUtil();		
		
		String SQL_GET_CM = "SELECT * FROM clearingmembers";
		
		try(Connection conn = DBConnection.openConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL_GET_CM);
			
			while(rs.next()) {
				int clearingMemberID = rs.getInt("clearingMemberID");
				String clearingMemberName = rs.getString("clearingMemberName");
				boolean isSubmitted= rs.getBoolean("isSubmitted");
				boolean isReportGenerated = rs.getBoolean("isReportGenerated");
				List<Trade> trades = tradeDao.getTradesByClearingMember(clearingMemberID);
				Balance balance = balanceDao.getBalanceByClearingMember(clearingMemberID);
				Balance obligationBalance = obligationBalanceDao.getBalanceByClearingMember(clearingMemberID);
				
				ClearingMember cm = new ClearingMember(clearingMemberID, clearingMemberName, balance, obligationBalance, trades, isSubmitted, isReportGenerated);
				
				clearingMembers.add(cm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clearingMembers;
	}

	public String getNameById(int clearingMemberId) {
		String clearingMemberName = "";
		
		String SQL_GET_NAME_BY_ID = "SELECT * FROM ClearingMembers WHERE clearingMemberId=?";
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_NAME_BY_ID);
			
			ps.setInt(1, clearingMemberId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				clearingMemberName = rs.getString("clearingMemberName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return clearingMemberName;
	}

	@Override
	public boolean updateIsSubmitted(boolean isSubmitted) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateIsReportGenerated(boolean isReportGenerated) {
		// TODO Auto-generated method stub
		return false;
	}
}
