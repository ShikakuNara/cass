package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Balance;
import com.dao.BalanceDaoUtil;

/**
 * Servlet implementation class DisplayBalanceServlet
 */
@WebServlet("/displayBalance")
public class DisplayBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int id = Integer.parseInt(request.getParameter("id"));
		int id=1;
		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		Balance balance = balanceDao.getBalanceByClearingMember(id);
		
		request.setAttribute("balance", balance);
		
		System.out.println(balance.getRights());
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("account.jsp");
		dispatcher.forward(request, response);
		
		System.out.println(balance);
	}
}
