package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.*;
import com.DB.DBConnection;
public class UserLoginDAO {
public UserBean userData=null;
public UserBean login(String user,String password) {
	
	try {
		//load db-connection
		Connection con = DBConnection.getCon();
		//prepare queries to retrived data from db
		PreparedStatement ps = con.prepareStatement("select * from users where email=? and password=?");
		
		//get data from browser
		ps.setString(1, user);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			//UserBean-obj
			 userData = new UserBean();
			//set data from ps to job
			 userData.setId(rs.getInt(1));
			 userData.setName(rs.getString(2));
			 userData.setQualification(rs.getString(3));
			 userData.setEmail(rs.getString(4));
			 userData.setPassWord(rs.getString(5));
			 userData.setRole(rs.getString(6));
			
			
		}//end of loop
		
	
	
} catch (SQLException e) {
	e.printStackTrace();
}
	
	
	
	
	return userData;
}
}
