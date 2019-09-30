package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.User;
import com.beans.User.Role;
import com.interfaces.UserDao;

public class UserDaoUtil implements UserDao {

	@Override
	public User getPassword(String username) {
		
		User user = new User();
		
		try(Connection conn = DBConnection.openConnection())
		{
		PreparedStatement ps = conn.prepareStatement("select * from users where username =?");
		ps.setString(1, username);
		
		ResultSet rs =ps.executeQuery();
		if(rs.next()) {
			//User user = new User() ;
			user.setPassword(rs.getString("password"));
			user.setClearingMemberId(rs.getInt("clearingmemberid"));
			user.setUsername(rs.getString("username"));
			
			 Role rol =  Role.valueOf(rs.getString("role"));
			 user.setRole(rol);
			return user;
			
		} else {
			return null;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return user;

	}
}
