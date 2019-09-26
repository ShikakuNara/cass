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
import com.dao.BalanceDaoUtil;

/**
 * Servlet implementation class IssueStockBonusServlet
 */
@WebServlet("/IssueStockBonus")
public class IssueStockBonusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Stock Bonus");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		List<Balance> balances = action.issueStockBonus(0.5, memberBalance , "Apple");
		System.out.println(balances);
		
		balanceDao.updateAllBalancesBySecurity(balances, "Apple");

		System.out.println("Stocks updated");
	}

}
