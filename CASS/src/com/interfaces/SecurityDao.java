package com.interfaces;

import com.beans.Security;

public interface SecurityDao {
	public String getNameById(int securityId);
	public Security getSecurityByName(String securityName);
}
