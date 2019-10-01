package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ClearingMember;
import com.dao.ClearingMemberDaoUtil;

/**
 * Servlet implementation class UpdateSubmittedServlet
 */
@WebServlet("/updateSubmit")
public class UpdateSubmittedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Update Submit");
		
		int id = (int) request.getSession().getAttribute("cmid");
		
		ClearingMemberDaoUtil memberDao = new ClearingMemberDaoUtil();
		ClearingMember member = new ClearingMember();
		member.setClearingMemberID(id);
		member.setSubmitted(false);
		memberDao.updateIsSubmitted(member); 
		request.setAttribute("message", "Trade successfully submitted to clearing house!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("loading.jsp");
		dispatcher.forward(request, response);	
	}
}
