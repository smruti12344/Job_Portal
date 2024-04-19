package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.*;
import com.DB.DBConnection;

public class UserRegisterDAO {
	public int k=0;
	public int register(UserBean user) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("insert into users(name,qualification,email,password,role) values(?,?,?,?,?)");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			ps.setString(1,user.getName() );
			ps.setString(2,user.getQualification());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPassWord());
			ps.setString(5,user.getRole());
			k=ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return k;
	}
}
