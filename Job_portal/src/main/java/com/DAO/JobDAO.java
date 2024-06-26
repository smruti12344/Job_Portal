package com.DAO;
import com.Bean.*;
import com.DB.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobDAO {
	public int k=0;
	public int addJob(JobBean job) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("insert into job(title,description,category,status,location) values(?,?,?,?,?)");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			ps.setString(1,job.getTitle() );
			ps.setString(2,job.getDescriPtion());
			ps.setString(3,job.getCatagory());
			ps.setString(4,job.getStatus());
			ps.setString(5,job.getLocation());
			k=ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return k;
	}

}
