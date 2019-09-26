package com.interfaces;

import java.util.List;

import com.beans.Rights;

public interface RightDao {
	public int addRight(Rights rights, int clearingMemberId);
	public int updateQuantity(int clearingMemberId, int quantity, String securityName);
	public List<Rights> getRightsByClearingMember(int clearingMemberId);
}
