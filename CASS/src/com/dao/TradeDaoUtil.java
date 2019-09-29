package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Trade;
import com.interfaces.TradeDao;

public class TradeDaoUtil implements TradeDao{
	
	public TradeDaoUtil() {
		System.out.println("tradeDao");
	}
	public List<Trade> getAllTrades(){
		List<Trade> trades = new ArrayList<Trade>();
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		
		String SQL_GET_TRADES = "SELECT * FROM trades";
		
		try(Connection conn = DBConnection.openConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL_GET_TRADES);
			while (rs.next()) {
				int id = rs.getInt("tradeid");
				String day = "MONDAY";
				int securityId = rs.getInt("securityId");
				String securityName = securityDao.getNameById(securityId);
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int buyerId = rs.getInt("buyerId");
				int sellerId = rs.getInt("sellerId");
				String buyer = clearingMemberDao.getNameById(buyerId);
				String seller = clearingMemberDao.getNameById(sellerId);
				Trade trade = new Trade(id, day, securityName, quantity, price, buyer, seller);
				
				trades.add(trade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trades;
	}

	@Override
	public List<Trade> getTradesByClearingMember(int clearingMemberID) {
		List<Trade> trades = new ArrayList<Trade>();
		
		String SQL_GET_TRADES_BY_CM = "SELECT * FROM trades WHERE buyerID=? OR sellerID=?";
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_TRADES_BY_CM);
			
			ps.setInt(1, clearingMemberID);
			ps.setInt(2, clearingMemberID);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("tradeid");
				String day ="MONDAY";
				int securityId = rs.getInt("securityId");
				String securityName = securityDao.getNameById(securityId);
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int buyerId = rs.getInt("buyerId");
				int sellerId = rs.getInt("sellerId");
				String buyer = clearingMemberDao.getNameById(buyerId);
				String seller = clearingMemberDao.getNameById(sellerId);
				Trade trade = new Trade(id, day, securityName, quantity, price, buyer, seller);
				
				System.out.println(trade);
				trades.add(trade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trades;
	}

	@Override
	public Trade getTrade(int tradeID) {
		Trade t = null;
		String SQL_GET_TRADE_BY_TRADEID = "SELECT * FROM trades WHERE tradeID=?" ;
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_TRADE_BY_TRADEID);
			
			ps.setInt(1, tradeID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("tradeid");
				String day ="MONDAY";
				int securityId = rs.getInt("securityId");
				String securityName = securityDao.getNameById(securityId);
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int buyerId = rs.getInt("buyerId");
				int sellerId = rs.getInt("sellerId");
				String buyer = clearingMemberDao.getNameById(buyerId);
				String seller = clearingMemberDao.getNameById(sellerId);
				t = new Trade(id, day, securityName, quantity, price, buyer, seller);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return t;
	}
	@Override
	public boolean updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteTrade(Trade trade) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addTrade(Trade trade) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		
		TradeDao t = new  TradeDaoUtil();
		List<Trade> trades  = t.getTradesByClearingMember(1);
		System.out.println(trades);
	}
	
	
}
