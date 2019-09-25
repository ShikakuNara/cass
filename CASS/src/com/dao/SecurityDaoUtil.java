package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
