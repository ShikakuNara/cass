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
		
		System.out.println("Rights");
		CorporateActions action = new CorporateActions();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> memberBalance = balanceDao.getAllBalances();
		System.out.println(memberBalance);
		List<Balance> rightsBalance = action.issueRights(0.5, memberBalance , 165, "Apple");
		System.out.println(rightsBalance);
		
		RightDaoUtil rightDao = new RightDaoUtil();
		
		for(Balance balance: rightsBalance) {
		
			List<Rights> rights = balance.getRights();
			for(Rights right: rights)
			{
				if(right.getSecurityName().equals("Apple"))
				{
					int r = rightDao.addRight(right, balance.getClearingMemberId());
					if(r>0)
						System.out.println("UPDATED");
					else
						System.out.println("NOT UPDATED");
				}
			}
		}
		
		System.out.println("Rights updated");
	}

}
