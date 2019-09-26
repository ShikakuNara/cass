package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.ClearingMember;
import com.beans.Rights;
import com.interfaces.RightDao;

public class RightDaoUtil implements RightDao{

	@Override
	public int addRight(Rights rights, int clearingMemberId) {
		// TODO Auto-generated method stub
		
		String SQL_ADD_RIGHTS = "insert into rights(clearingmemberid, securityid, quantity, price) values(?,?,?,?)";
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		int securityId = securityDao.getIdByName(rights.getSecurityName());
		int rows = 0;
		
		try(Connection conn = DBConnection.openConnection()){
			PreparedStatement ps = conn.prepareStatement(SQL_ADD_RIGHTS);
			
			ps.setInt(1, clearingMemberId);
			ps.setInt(2, securityId);
			ps.setInt(3, rights.getQuantity());
			ps.setDouble(4, rights.getMarketPrice());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows;
	}

	@Override
	public int updateQuantity(int clearingMemberId, int quantity, String securityName) {
		
		String SQL_UPDATE_QUANTITY = "update rights set quantity=? where clearingmemberid=? and securityid=?";
		SecurityDaoUtil securityDao = new SecurityDaoUtil();
		int securityId = securityDao.getIdByName(securityName);
		int rows = 0;
		
		try(Connection conn = DBConnection.openConnection()){
			
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_QUANTITY);
			
			ps.setInt(1, quantity);
			ps.setInt(2, clearingMemberId);
			ps.setInt(3, securityId);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows;
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

	public static void main(String[] args) {
		
		System.out.println("Rights");
		RightDaoUtil rightsDao = new RightDaoUtil();
		
		Rights rights = new Rights();
		rights.setMarketPrice(100);
		rights.setQuantity(150);
		rights.setSecurityName("Apple");
		
	//	int rows = rightsDao.addRight(rights, 1);
		
		rightsDao.updateQuantity(1, 50, "Apple");
		
		List<Rights> r = rightsDao.getRightsByClearingMember(1);
		System.out.println(r);
		
		
	}

}

