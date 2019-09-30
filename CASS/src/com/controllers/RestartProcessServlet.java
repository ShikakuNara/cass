package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GenarateRandomTrade;

/**
 * Servlet implementation class RestartProcessServlet
 */
@WebServlet("/restart")
public class RestartProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				GenarateRandomTrade generateRandomTrades = new GenarateRandomTrade();
				generateRandomTrades.generateTrades();	
				
				try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("clearinghouse.jsp");
				request.setAttribute("message", "Process restarted");
				request.setAttribute("status", "success");
				
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		
		

	}


