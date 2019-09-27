package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Trade;
import com.dao.TradeDaoUtil;
import com.interfaces.TradeDao;

/**
 * Servlet implementation class Trades
 */
@WebServlet("/trades")
public class Trades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TradeDao t = new  TradeDaoUtil();
		List<Trade> trades  = t.getTradesByClearingMember(1);
		System.out.println(trades);
		System.out.println("Count: "+trades.size());
	
	}

	
}
