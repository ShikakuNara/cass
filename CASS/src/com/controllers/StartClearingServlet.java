package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.MultiLateralNetting;
import com.beans.Balance;
import com.beans.ClearingMember;
import com.dao.ClearingMemberDaoUtil;
import com.dao.ObligationBalanceDaoUtil;

@WebServlet("/startClearing")
public class StartClearingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClearingMemberDaoUtil clearingMemberDao = new ClearingMemberDaoUtil();
		List<ClearingMember> clearingMembers = clearingMemberDao.getAllClearingMembers();
		
		MultiLateralNetting netting = new MultiLateralNetting();
		//netting.calculateSecurityObligation(clearingMembers);
		List<Balance> obligation = netting.calculateFundObligation(clearingMembers);	
		
		ObligationBalanceDaoUtil balanceDao = new ObligationBalanceDaoUtil();
		balanceDao.updateAllBalances(obligation);
		
		clearingMemberDao.updateIsReportGenerated();
	}

}
