package com.interfaces;

import com.beans.Security;

public interface SecurityDao {
	public String getNameById(int securityId);
	public int getIdByName(String securityName);
	public Security getSecurityByName(String securityName);
}
