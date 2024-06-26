package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.*;
import com.DB.DBConnection;

public class ProfileUpdateDAO {
	public int k=0;
	public int updateProfile(UserBean user) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("update  users set name=?,qualification=?,email=?,password=? where id=?");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			ps.setString(1,user.getName() );
			ps.setString(2,user.getQualification());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPassWord());
	
			ps.setInt(5, user.getId());
			k=ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return k;
	}
}
