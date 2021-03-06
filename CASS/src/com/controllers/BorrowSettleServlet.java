package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.ShortageHandling;
import com.beans.Balance;
import com.beans.ClearingMember;
import com.dao.BalanceDaoUtil;
import com.dao.ClearingMemberDaoUtil;
import com.dao.ObligationBalanceDaoUtil;

/**
 * Servlet implementation class BorrowSettleServlet
 */
@WebServlet("/borrowsettle")
public class BorrowSettleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Stock Shortage");
		ShortageHandling shortageHandling = new  ShortageHandling();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();

		Balance memberBalance  = balanceDao.getBalanceByClearingMember(1);
		ObligationBalanceDaoUtil obligationDao = new ObligationBalanceDaoUtil();
		Balance obligationBalance = obligationDao.getBalanceByClearingMember(1);
		ClearingMemberDaoUtil memberDao=new ClearingMemberDaoUtil();
		Balance shortBalance = shortageHandling.calculateShortage(memberBalance, obligationBalance);

		Balance balance = obligationDao.getBalanceByClearingMember(1);
		
		shortageHandling.settleShortage(shortBalance,obligationBalance, memberBalance);

		//balance.setFunds(0);
		Map<String, Integer> security = balance.getSecurityBalance();
		for(Map.Entry<String, Integer> entry:security.entrySet())
		{
			String securityName = entry.getKey();
			//security.put(securityName, 0);
		}
		balance.setSecurityBalance(security);

		System.out.println("Updated obligation: "+balance);
		List<Balance> balances = new ArrayList<Balance>();
		ShortageHandling shortageH = new  ShortageHandling();
		
		balances.add(balance);
		//obligationDao.updateAllBalances(balances );

		System.out.println("Settled");
		
		System.out.println("Obligation: "+obligationBalance);
		request.setAttribute("balance", memberBalance);
		request.setAttribute("short",shortBalance);
		request.setAttribute("obligation",obligationBalance);
		request.setAttribute("initialBalance",balanceDao.getInitialBalanceByClearingMember(1));
		if(memberDao.getReportGenerated()==6)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("settlreport.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("loading.jsp");
		dispatcher.forward(request, response);
		}
	}

}
