package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.ShortageHandling;
import com.beans.Balance;
import com.dao.BalanceDaoUtil;
import com.dao.ObligationBalanceDaoUtil;

/**
 * Servlet implementation class ReconcillationServlet
 */
@WebServlet("/recon")
public class ReconcillationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShortageHandling shortageHandling = new  ShortageHandling();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		ObligationBalanceDaoUtil obligationDao = new ObligationBalanceDaoUtil();
		Balance memberBalance  = balanceDao.getBalanceByClearingMember(6);
		Balance obligationBalance = obligationDao.getBalanceByClearingMember(6);
		Balance initialBalance=balanceDao.getInitialBalanceByClearingMember(6);

		Balance shortBalance = shortageHandling.calculateShortage(memberBalance, obligationBalance);
		
		request.setAttribute("balance", memberBalance);
		request.setAttribute("short", shortBalance);
		request.setAttribute("obligation", obligationBalance);
		request.setAttribute("initialBalnce",initialBalance);
		
		System.out.println("Balance: "+memberBalance);
		System.out.println("Short: "+shortBalance);
		System.out.println("Obligation: "+obligationBalance);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("reconstatement.jsp");
		dispatcher.forward(request, response);	
		
		
		

	}

}
