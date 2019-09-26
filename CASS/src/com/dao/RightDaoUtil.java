package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Rights;
import com.interfaces.RightDao;

public class RightDaoUtil implements RightDao{

	@Override
	public int addRight(Rights rights, int clearingMemberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuantity(int clearingMemberId, int quantity, String securityName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Rights> getRightsByClearingMember(int clearingMemberId) {
		List<Rights> rights = new ArrayList<Rights>();
		String SQL_GET_RIGHTS_BY_ID = "SELECT * FROM Rights WHERE clearingMemberId=?";
		
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_GET_RIGHTS_BY_ID);
			
			ps.setInt(1, clearingMemberId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int rightsId = rs.getInt("rightId");
				int securityId = rs.getInt("securityId");
				String securityName = securityDao.getNameById(securityId);
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				Rights right = new Rights(rightsId,price,securityName,quantity);
				rights.add(right);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rights;
	}

}
