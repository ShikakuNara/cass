package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.Balance;
import com.beans.Security;
import com.dao.BalanceDaoUtil;
import com.dao.SecurityDaoUtil;

public class ShortageHandling {
	
	public Balance calculateShortage (Balance memberBalance, Balance obligationBalance)
	{
		Balance shortageBalance = new Balance();
		
		double memberFund = memberBalance.getFunds();
		double obligationFund = obligationBalance.getFunds();
		double shortageFund = memberFund - obligationFund;
		
		if(shortageFund<0)
		{
			shortageBalance.setFunds(-shortageFund);
			//memberBalance.setFunds(0);
		}
		else
		{
			shortageBalance.setFunds(0);
			//memberBalance.setFunds(memberFund - obligationFund);
		}
		
		Map<String,Integer> memberSecurity = memberBalance.getSecurityBalance();
		Map<String,Integer> obligationSecurity = obligationBalance.getSecurityBalance();
		Map<String,Integer> shortSecurity = new HashMap<String, Integer>();
		
		for(Map.Entry<String, Integer> entry:obligationSecurity.entrySet())
		{
			String securityName = entry.getKey();
			Integer memberQuantity  = memberSecurity.get(securityName);
			Integer obligationQuantity  = entry.getValue();
			int shortQuantity = memberQuantity - obligationQuantity;
			if(shortQuantity  < 0)
			{
				shortSecurity.put(securityName, -shortQuantity);
				//memberSecurity.put(securityName, 0);
			}
			else
			{
				shortSecurity.put(securityName, 0);
				//memberSecurity.put(securityName, memberQuantity-obligationQuantity);
			}
				
		}
		shortageBalance.setSecurityBalance(shortSecurity);
		
		System.out.println(shortageBalance);
		
		//settleShortage(shortageBalance, memberBalance);
		
		return shortageBalance;
	}

	public void settleShortage(Balance shortageBalance, Balance obligtionBalance,Balance memberBalance) {
		double shortFundBal = shortageBalance.getFunds();
		System.out.println(shortFundBal);
		double fundsIR = 1.25;
		double fundInterest = (shortFundBal * ((fundsIR / 100f) * (2f / 365f)));
		System.out.println((2.5f / 36500f));
		System.out.println(fundInterest);
		double memberFund = memberBalance.getFunds();
		double obligationFund = obligtionBalance.getFunds();

		if(shortFundBal!=0)
		{
			double finalBalance = - (shortFundBal + fundInterest);
			memberBalance.setFunds(finalBalance);
		}
		else
		{
			memberBalance.setFunds(memberFund-obligationFund);
		}

		Map<String, Integer> shortSecBal = shortageBalance.getSecurityBalance();
		Map<String,Integer> memberSecurity=memberBalance.getSecurityBalance();
		Map<String,Integer> obligationSecurity=obligtionBalance.getSecurityBalance();

		if (shortSecBal.isEmpty()) {
			System.out.println("There is no security shortage");

		} else {
			for (Map.Entry<String, Integer> entry : shortSecBal.entrySet()) {

				String securityName = entry.getKey();
				
				Integer memberQuantity=memberSecurity.get(securityName);
				Integer obligationQuantity=obligationSecurity.get(securityName);
				if(entry.getValue()==0)
				{	
					memberSecurity.put(securityName, memberQuantity-obligationQuantity);
				}
				else
				{
					Integer securityQuantity = entry.getValue();
					SecurityDaoUtil securitydaoutil = new SecurityDaoUtil();

					double IR = securitydaoutil.getSecurityByName(securityName).getInterestRate();
					double marketPrice = securitydaoutil.getSecurityByName(securityName).getMarketPrice();
					double shortSecFund = securityQuantity * marketPrice;
					double secInterest = (shortSecFund * (IR / 100f) * (2f / 365f));
					System.out.println("Security ir "+secInterest);
					double finalBalance = memberBalance.getFunds() - secInterest;
					memberBalance.setFunds(finalBalance);
				}
				

			}
		}
		
		System.out.println("Fund shortage: "+memberBalance.getFunds());

		BalanceDaoUtil balanceDao = new BalanceDaoUtil();
		List<Balance> balances = new ArrayList<Balance>();
		balances.add(memberBalance);
		balanceDao.updateFundBalance(balances);
		balanceDao.updateSecurity(memberBalance);

	}
}
