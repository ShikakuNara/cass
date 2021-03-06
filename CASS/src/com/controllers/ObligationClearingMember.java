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
 * Servlet implementation class ObligationClearingMember
 */
@WebServlet("/ObligationClearingMember")
public class ObligationClearingMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("cmid");
		ShortageHandling shortageHandling = new  ShortageHandling();
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		ObligationBalanceDaoUtil obligationDao = new ObligationBalanceDaoUtil();
		Balance memberBalance  = balanceDao.getBalanceByClearingMember(id);
		Balance obligationBalance = obligationDao.getBalanceByClearingMember(id);

		Balance shortBalance = shortageHandling.calculateShortage(memberBalance, obligationBalance);
		
		System.out.println("Obligation:" +obligationBalance);
		System.out.println("Short: "+shortBalance);
		
		request.setAttribute("obligations", obligationBalance);
		request.setAttribute("short", shortBalance);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("oblreport.jsp");
		dispatcher.forward(request, response);	
	}

	
}
