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
				System.out.println("trade:"+trade);
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
				System.out.println("id"+buyerId);
				String buyer = clearingMemberDao.getNameById(buyerId);
				String seller = clearingMemberDao.getNameById(sellerId);
				t = new Trade(id, day, securityName, quantity, price, buyer, seller);
				System.out.println(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return t;
	}
	
	@Override
	public boolean updateTrade(Trade trade) {
		boolean updated = false;
		String SQL_UPDATE_TRADE="UPDATE trades SET securityId = ?,quantity=?,price=?,buyerID=?,sellerID=?  WHERE tradeId = ?";
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		int buyerID = clearingMemberDao.getIdByName(trade.getBuyer());
		System.out.println(buyerID);
		int sellerID = clearingMemberDao.getIdByName(trade.getSeller());
		System.out.println(sellerID);
		int securityID = securityDao.getIdByName(trade.getSecurityName());
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_TRADE);
			ps.setInt(1, securityID );
			ps.setInt(2, trade.getQuantity());
			ps.setDouble(3, trade.getPrice());
			ps.setInt(4, buyerID );
			ps.setInt(5, sellerID );
			ps.setInt(6, trade.getTradeId() );
			
			int update = ps.executeUpdate();
			if(update>0) {
				updated=true;
				System.out.println("trade updated successfully");
			}
			else {
				updated=false;
				System.out.println("No change occurred");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return updated;
		
	}
	
	
	@Override
	public boolean deleteTrade(int tradeID) {
	     Boolean updated=false;
		String SQL_DELETE_TRADE = "DELETE FROM trades WHERE tradeID=?"; 
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_TRADE);
			
			ps.setInt(1, tradeID);
			int update = ps.executeUpdate();
			if(update >0) {
				System.out.println("Deleted Records Successfully");
				updated=true;
			}
			else {
				System.out.println("No records found");
				updated=false;
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		return updated;
		
	
	}
	@Override
	public int addTrade(Trade trade) {
		int tid = 0;
		if(trade.getTradeId()==0)
		{
		String SQL_ADD_TRADE = "insert into trades values(?,?,?,?,?,?)";
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		int buyerID = clearingMemberDao.getIdByName(trade.getBuyer());
		
		int sellerID = clearingMemberDao.getIdByName(trade.getSeller());
		int securityID = securityDao.getIdByName(trade.getSecurityName());
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_ADD_TRADE);
			String SQL_GET_TRADE = "select max(tradeid) from trades where tradeid is not null";
			try(Connection conn1 = DBConnection.openConnection()){
				PreparedStatement s = conn.prepareStatement(SQL_GET_TRADE);
				ResultSet rs=s.executeQuery();
				while(rs.next())
				{
					tid=rs.getInt("max(tradeid)");
				}
				
				System.out.println(tid);
			}
			
			ps.setInt(1, tid+1 );
			ps.setInt(2, securityID );
			ps.setInt(3, trade.getQuantity());
			ps.setDouble(4, trade.getPrice());
			ps.setInt(5, buyerID );
			ps.setInt(6, sellerID );
			System.out.println("before insert");
		int	rows = ps.executeUpdate();
if(rows>0) {
			
		
			try(Connection conn1 = DBConnection.openConnection()){
				PreparedStatement s = conn.prepareStatement(SQL_GET_TRADE);
				ResultSet rs=s.executeQuery();
				while(rs.next())
				{
					tid=rs.getInt("max(tradeid)");
				}
				
				System.out.println(tid);
			}
		}
		else {
			tid=0;
			System.out.println("Something is wrong");
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
		else {
			
			String SQL_ADD_TRADE = "insert into trades values(?,?,?,?,?,?)";
			SecurityDaoUtil securityDao = new SecurityDaoUtil();
			ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
			int buyerID = clearingMemberDao.getIdByName(trade.getBuyer());
			
			int sellerID = clearingMemberDao.getIdByName(trade.getSeller());
			int securityID = securityDao.getIdByName(trade.getSecurityName());
			try(Connection conn = DBConnection.openConnection()){
				PreparedStatement ps = conn.prepareStatement(SQL_ADD_TRADE);
			
				ps.setInt(1, trade.getTradeId() );
				ps.setInt(2, securityID );
				ps.setInt(3, trade.getQuantity());
				ps.setDouble(4, trade.getPrice());
				ps.setInt(5, buyerID );
				ps.setInt(6, sellerID );
				System.out.println("before update");
			int	rows = ps.executeUpdate();
			if(rows>0) {
				
				tid=trade.getTradeId();
			}
			else {
				tid=0;
				System.out.println("Something is wrong");
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return tid;
		
		
	}
	
	public static void main(String[] args) {
		
		TradeDao t = new  TradeDaoUtil();
		List<Trade> trades  = t.getTradesByClearingMember(1);
		System.out.println(trades);
	}
	
	
}
