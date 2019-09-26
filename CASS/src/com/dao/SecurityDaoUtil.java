package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Security;
import com.interfaces.SecurityDao;

public class SecurityDaoUtil implements SecurityDao {

	@Override
	public String getNameById(int securityId) {
		String securityName = "";
		String SQL_GET_NAME_BY_ID = "SELECT * FROM Security WHERE securityId=?";
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_NAME_BY_ID);
			
			ps.setInt(1, securityId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				securityName = rs.getString("securityName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return securityName;
	}
	
	public int getIdByName(String securityName) {
		int id = 0;
		String SQL_GET_ID_BY_NAME = "SELECT * FROM Security WHERE securityName=?";
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_ID_BY_NAME);
			
			ps.setString(1, securityName);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("securityID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public Security getSecurityByName(String securityName) {
		Security security = new Security();
		
		String SQL_GET_SECURITY_BY_NAME = "SELECT * FROM Security WHERE securityName=?";
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_SECURITY_BY_NAME);
			
			ps.setString(1, securityName);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				security.setSecurityName(securityName);
				security.setInterestRate(rs.getInt("interestRate"));
				security.setMarketPrice(rs.getDouble("price"));
				security.setFaceValue(rs.getDouble("facevalue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return security;
	}

}
