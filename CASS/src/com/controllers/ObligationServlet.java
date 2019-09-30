package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Balance;
import com.beans.ClearingMember;
import com.dao.ClearingMemberDaoUtil;
import com.dao.ObligationBalanceDaoUtil;

/**
 * Servlet implementation class ObligationServlet
 */
@WebServlet("/obligation")
public class ObligationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClearingMemberDaoUtil memberDao = new ClearingMemberDaoUtil();
		List<ClearingMember> members = memberDao.getAllClearingMembers();
		
		ObligationBalanceDaoUtil obligationDao = new ObligationBalanceDaoUtil();
		List<Balance> obligations = obligationDao.getAllBalances();
		
	    request.setAttribute("members", members);
		request.setAttribute("obligation", obligations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("obligation.jsp");
		dispatcher.forward(request, response);		
		
	}

}
