package com.interfaces;

import java.util.List;

import com.beans.Trade;

public interface TradeDao {
	public List<Trade> getAllTrades();
	public List<Trade> getTradesByClearingMember(int clearingMemberID);
	public Trade getTrade(int tradeID);	
	public boolean updateTrade(Trade trade);
	public boolean deleteTrade(int tradeId);
	public int addTrade(Trade trade);
}
