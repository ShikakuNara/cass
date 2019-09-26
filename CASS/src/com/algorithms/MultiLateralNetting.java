package com.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.beans.Balance;
import com.beans.ClearingMember;
import com.beans.Trade;

public class MultiLateralNetting {

	public List<ClearingMember> calculateFundObligation(List<ClearingMember> clearingMembers)
	{

		clearingMembers.stream().forEach((member) -> {

			System.out.println("\n"+member.getClearingMemberName());
			List<Trade> tradeList = member.getTrades();

			double totalBuy = tradeList.stream()
					.filter((trade)->{return trade.getBuyer().equals(member.getClearingMemberName());})
					.mapToDouble(f -> f.getPrice()*f.getQuantity())
					.sum();
			System.out.println("Total buy: "+totalBuy);

			double totalSell = tradeList.stream()
					.filter((trade)->{return trade.getSeller().equals(member.getClearingMemberName());})
					.mapToDouble(f -> f.getPrice()*f.getQuantity())
					.sum();
			System.out.println("Total Sell: "+totalSell);

			double fund=0;
			fund = totalBuy - totalSell;
			System.out.println("Fund Obligation: "+fund);
			
			Balance balance = member.getObligationBalance();
			balance.setFunds(fund);
			
			member.setObligationBalance(balance);
											
		});

		return clearingMembers;
	}

	public List<ClearingMember> calculateSecurityObligation(List<ClearingMember> clearingMembers)
	{

		clearingMembers.stream().forEach((member) -> {

			System.out.println("**********************\n"+member.getClearingMemberName());

			List<Trade> tradeList = member.getTrades();

		//	Map<String, Integer> securityObligationCredit = new HashMap<String, Integer>();
		//	Map<String, Integer> securityObligationDebit =  new HashMap<String, Integer>();
			Map<String, Integer> securityObligation =  new HashMap<String, Integer>();


			List<Trade> totalBuy = tradeList.stream()
					.filter((trade)->{return trade.getBuyer().equals(member.getClearingMemberName());})
					.collect(Collectors.toList());
			totalBuy.stream().forEach((trade) -> {
				int prevQuantity = 0;
				if(securityObligation.containsKey(trade.getSecurityName()))
					prevQuantity = securityObligation.get(trade.getSecurityName());
				securityObligation.put(trade.getSecurityName(), prevQuantity-trade.getQuantity());
			});
			
//			System.out.println("\n**BUY**");
//			totalBuy.forEach((trade) -> { 
//				System.out.println("Security: "+trade.getSecurityName()+" Quantity: "+trade.getQuantity());
//			});
			//System.out.println("Credit"+securityObligation);


			List<Trade> totalSell = tradeList.stream()
					.filter((trade)->{return trade.getSeller().equals(member.getClearingMemberName());})
					.collect(Collectors.toList());
			totalSell.stream().forEach((trade) -> {
				int prevQuantity = 0;
				if(securityObligation.containsKey(trade.getSecurityName()))
					prevQuantity = securityObligation.get(trade.getSecurityName());
				securityObligation.put(trade.getSecurityName(), prevQuantity+trade.getQuantity());
			});
			
//			System.out.println("\n**SELL**");
//			totalSell.forEach((trade) ->{ 
//				System.out.println("Security: "+trade.getSecurityName()+" Quantity: "+trade.getQuantity());
//			});

		/*	
			System.out.println("Debit"+securityObligationDebit);

			for (String key : securityObligationCredit.keySet()) {
				if (securityObligationDebit.containsKey(key)) {
					int creditValue = securityObligationCredit.get(key);
					int debitValue = securityObligationDebit.get(key);
					securityObligation.put(key, debitValue - creditValue);
				}
				else
				{
					int creditValue = securityObligationCredit.get(key);
					securityObligation.put(key, creditValue);
				}
			}
			
			for (String key : securityObligationDebit.keySet()) {
				if (securityObligationDebit.containsKey(key)) {
					int creditValue = securityObligationCredit.get(key);
					int debitValue = securityObligationDebit.get(key);
					securityObligation.put(key, debitValue - creditValue);
				}
			}

			System.out.println(securityObligationCredit);
			System.out.println(securityObligationDebit);*/

			System.out.println("\nFinal obligation: ");
			System.out.println(securityObligation);
			
			Balance balance = member.getObligationBalance();
			balance.setSecurityBalance(securityObligation);
		});

		return clearingMembers;
	}
}