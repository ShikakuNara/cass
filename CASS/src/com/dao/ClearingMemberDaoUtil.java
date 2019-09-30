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
	public int getIdByName(String clearingMemberName) {
		int id = 0;
		String SQL_GET_ID_BY_NAME = "SELECT * FROM ClearingMembers WHERE clearingMemberName=?";
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_ID_BY_NAME);
			
			ps.setString(1, clearingMemberName);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("clearingMemberID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	
		
	}
	@Override
	public int getReportGenerated(){
	String SQL_GET_CM = "SELECT * FROM clearingmembers";
	int count=0;
	boolean isSubmitted=false;
		try(Connection conn = DBConnection.openConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL_GET_CM);
			while(rs.next())
			{
				 isSubmitted=rs.getBoolean("isSubmitted");
				 if(isSubmitted)
				 {
					 count++;
				 }
			}
			return count;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}
	

	@Override
	public boolean updateIsSubmitted(ClearingMember clearingMember){
		boolean isSubmitted=clearingMember.isSubmitted();
		if(isSubmitted==false)
			isSubmitted=true;
		else
			isSubmitted=false;
		
		String SQL_GET_CM = "Update clearingMembers set isSubmitted=? where clearingMemberID=?";
		
		try(Connection conn = DBConnection.openConnection()){
           PreparedStatement ps = conn.prepareStatement(SQL_GET_CM);
           ps.setInt(2,clearingMember.getClearingMemberID());
           ps.setBoolean(1,isSubmitted);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

	@Override
	public boolean updateIsReportGenerated() {
		String query1="Select distinct isReportGenerated from clearingMembers";
		String SQL_GET_CM = "Update clearingMembers set isReportGenerated=?";
		int rows=0;
		boolean isReportGenerated=false;
		
		try(Connection conn = DBConnection.openConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query1);
			PreparedStatement ps = conn.prepareStatement(SQL_GET_CM);
			while(rs.next())
			{
			 isReportGenerated=rs.getBoolean("isReportGenerated");
				
			}
			if(isReportGenerated==true) {
				ps.setBoolean(1,false);
				
			}
			else
				ps.setBoolean(1,true);
			 rows = ps.executeUpdate();
			 if(rows>0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	
	}
}
