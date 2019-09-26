package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.CorporateActions;
import com.beans.Balance;
import com.beans.Security;
import com.dao.BalanceDaoUtil;

/**
 * Servlet implementation class IssueCashDividendServlet
 */
@WebServlet("/IssueCashDividend")
public class IssueCashDividendServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Stock Split");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		
		Security security = new Security();
		security.setSecurityName("Apple");
		security.setFaceValue(100);
		security.setInterestRate(7);
		security.setMarketPrice(120);
		
		
		List<Balance> balances = action.issueCashDividend(10, memberBalance , security);
		System.out.println(balances);
		
		balanceDao.updateAllBalancesBySecurity(balances, "Apple");
		
		
		System.out.println("Stocks updated");
	}


}
