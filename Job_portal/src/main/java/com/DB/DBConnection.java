package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con=null;

	//singletone class design pattern
	private DBConnection() {}
	static {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection
	con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/job_portal","root","root");
//		System.out.println("connection established:"+con);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		
		
		return con;
	}

}
