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
import com.beans.Security;
import com.dao.BalanceDaoUtil;
import com.dao.SecurityDaoUtil;

/**
 * Servlet implementation class IssueCashDividendServlet
 */
@WebServlet("/IssueCashDividend")
public class IssueCashDividendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double percent = Double.parseDouble(request.getParameter("percent"));
		String securityName = request.getParameter("security");
		
		System.out.println("Stock Split");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		Security security = new Security();
		security = securityDao.getSecurityByName(securityName);
		System.out.println(security);
		
		List<Balance> balances = action.issueCashDividend(percent, memberBalance , security);
		System.out.println(balances);
		
		balanceDao.updateFundBalance(balances);
		
		System.out.println("Stocks updated");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		request.setAttribute("message", "Cash Dividend issued successfully!");
		dispatcher.forward(request, response);
		
	}
}
