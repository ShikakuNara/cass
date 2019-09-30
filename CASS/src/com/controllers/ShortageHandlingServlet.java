package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.CorporateActions;
import com.algorithms.ShortageHandling;
import com.beans.Balance;
import com.beans.Security;
import com.dao.BalanceDaoUtil;
import com.dao.ObligationBalanceDaoUtil;
import com.dao.SecurityDaoUtil;

/**
 * Servlet implementation class ShortageHandlingServlet
 */
@WebServlet("/shortageHandling")
public class ShortageHandlingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Stock Shortage");
		ShortageHandling shortageHandling = new  ShortageHandling();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();

		Balance memberBalance  = balanceDao.getBalanceByClearingMember(1);
		ObligationBalanceDaoUtil obligationDao = new ObligationBalanceDaoUtil();
		Balance obligationBalance = obligationDao.getBalanceByClearingMember(1);
		
		
		System.out.println("Obligation: "+obligationBalance);
		request.setAttribute("balance", obligationBalance);
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountobligation.jsp");
		dispatcher.forward(request, response);
		
		Balance shortBalance = shortageHandling.calculateShortage(memberBalance, obligationBalance);

		/*Balance balance = obligationDao.getBalanceByClearingMember(6);

		balance.setFunds(0);
		Map<String, Integer> security = balance.getSecurityBalance();
		for(Map.Entry<String, Integer> entry:security.entrySet())
		{
			String securityName = entry.getKey();
			security.put(securityName, 0);
		}
		balance.setSecurityBalance(security);

		System.out.println("Updated obligation: "+balance);
		List<Balance> balances = new ArrayList<Balance>();
		balances.add(balance);
		obligationDao.updateAllBalances(balances );

		System.out.println("Settled");*/

	}

}
