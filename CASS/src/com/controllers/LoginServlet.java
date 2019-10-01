   package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Trade;
import com.beans.User;
import com.beans.User.Role;
import com.dao.TradeDaoUtil;
import com.dao.UserDaoUtil;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDaoUtil userDao  =new UserDaoUtil();
		User user = userDao.getPassword(username);
		
		System.out.println("User Role: "+user.getRole());
		
		if(user.getPassword().equals(password) && user.getRole().equals(Role.ADMIN))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("corporateactions.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(user.getPassword().equals(password) && user.getRole().equals(Role.CH))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("clearinghouse.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(user.getPassword().equals(password) && user.getRole().equals(Role.CM))
		{
		
			int id = user.getClearingMemberId();
			HttpSession session = request.getSession();
			session.setAttribute("cmid", id);
			response.sendRedirect("tradesdata");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("trades1");
//			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}	
	}

}
