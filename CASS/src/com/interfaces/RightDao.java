package com.interfaces;

import com.beans.Rights;

public interface RightDao {
	public int addRight(Rights rights, int clearingMemberId);
	public int updateQuantity(int clearingMemberId, int quantity, String securityName);
}
