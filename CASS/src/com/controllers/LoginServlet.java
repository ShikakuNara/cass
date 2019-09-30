   package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
			TradeDaoUtil memberDao = new TradeDaoUtil();
			int id =1;
			List<Trade> trades = memberDao.getTradesByClearingMember(id);
			

			
			
			System.out.println("Count:"+trades.size());

			request.setAttribute("trades", trades);
			request.setAttribute("name", "Citi");
			RequestDispatcher dispatcher = request.getRequestDispatcher("clearingmember.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}	
	}

}
