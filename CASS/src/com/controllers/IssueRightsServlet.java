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
import com.beans.Rights;
import com.dao.BalanceDaoUtil;
import com.dao.RightDaoUtil;

/**
 * Servlet implementation class IssueRights
 */
@WebServlet("/IssueRights")
public class IssueRightsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double factor = Double.parseDouble(request.getParameter("factor"));
		double price = Double.parseDouble(request.getParameter("price"));
		String securityName = request.getParameter("security");
		
		System.out.println("Rights");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		List<Balance> rightsBalance = action.issueRights(factor, memberBalance , price, securityName);
		System.out.println(rightsBalance);
		
		RightDaoUtil rightDao = new RightDaoUtil();
		
		for(Balance balance: rightsBalance) {
		
			List<Rights> rights = balance.getRights();
			for(Rights right: rights)
			{
				if(right.getSecurityName().equals(securityName))
				{
					int r = rightDao.addRight(right, balance.getClearingMemberId());
				}
			}
		}	
		System.out.println("Rights updated");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		request.setAttribute("message", securityName + " Rights issued successfully!");
		dispatcher.forward(request, response);
	}
}
