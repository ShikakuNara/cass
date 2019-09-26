package com.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.Balance;
import com.beans.Rights;
import com.beans.Security;

public class CorporateActions {

	public List<Balance> issueStockSplit(double factor, List<Balance> memberBalance, String securityName) {

		Map<String, Integer> security = new HashMap<String, Integer>();
		for(int i=0; i<memberBalance.size(); i++) {

			security=memberBalance.get(i).getSecurityBalance();

			if(security.containsKey(securityName))
			{
				Integer prevQuantity = security.get(securityName);
				Integer newQuantity = (int) Math.round(((prevQuantity* factor)));
				security.put(securityName, newQuantity);
			}

		}

		return memberBalance;
	}

	public List<Balance> issueStockBonus(double factor, List<Balance> memberBalance, String securityName) {

		Map<String, Integer> security = new HashMap<String, Integer>();
		for(int i=0; i<memberBalance.size(); i++) {
			security=memberBalance.get(i).getSecurityBalance();

			if(security.containsKey(securityName))
			{
				Integer prevQuantity = security.get(securityName);
				Integer newQuantity = (int) Math.round(( prevQuantity+(prevQuantity* factor)));
				security.put(securityName, newQuantity);
			}
		}

		return memberBalance;
	}


	public List<Balance> issueCashDividend(double percent, List<Balance> memberBalance, Security securityObject) {

		Map<String, Integer> security = new HashMap<String, Integer>();
		for(int i=0; i<memberBalance.size(); i++) {

			security=memberBalance.get(i).getSecurityBalance();

			if(security.containsKey(securityObject.getSecurityName()))
			{
				int quantity = security.get(securityObject.getSecurityName());
				double fund = memberBalance.get(i).getFunds();
				fund  = fund + (quantity*securityObject.getFaceValue()*(percent/100));
				memberBalance.get(i).setFunds(fund);
			}
		}

		return memberBalance;
	}

	public List<Balance> issueRights(double factor, List<Balance> memberBalance, double marketPrice, String securityName)
	{
		Balance balance;
		for(int i=0; i<memberBalance.size(); i++) {

			balance=memberBalance.get(i);
			Map<String, Integer> securityBalance = new HashMap<String, Integer>();
			securityBalance = balance.getSecurityBalance();
			List<Rights> rights = balance.getRights();
			Integer newQuantity = 0;

			if(securityBalance.containsKey(securityName))
			{
				Integer prevQuantity = securityBalance.get(securityName);
				newQuantity = (int) Math.round((prevQuantity* factor));

				Rights securityRights = new Rights();
				securityRights.setMarketPrice(marketPrice);
				securityRights.setSecurityName(securityName);
				securityRights.setQuantity(newQuantity);
				rights.add(securityRights);
				balance.setRights(rights);
			}

		}
		return memberBalance;
	}
}
