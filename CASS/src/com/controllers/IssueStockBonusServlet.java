package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Stock Bonus");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		double factor=Double.parseDouble(request.getParameter("factor"));
		String security=request.getParameter("security");
		List<Balance> balances = action.issueStockBonus(factor, memberBalance ,security);
		
		balanceDao.updateAllBalancesBySecurity(balances,security);
RequestDispatcher dispatcher=request.getRequestDispatcher("corporateactions.jsp");
request.setAttribute("message","Stock Bonus Issued Sucessfully");
dispatcher.forward(request,response);
		System.out.println("Stocks updated");
	}

}
