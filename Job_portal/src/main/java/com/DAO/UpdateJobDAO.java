package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.JobBean;
import com.DB.DBConnection;

public class UpdateJobDAO {
	public int k=0;
	public int updateJob(JobBean job) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("update  job set title=?,description=?,category=?,status=?,location=? where id=?");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			ps.setString(1,job.getTitle() );
			ps.setString(2,job.getDescriPtion());
			ps.setString(3,job.getCatagory());
			ps.setString(4,job.getStatus());
			ps.setString(5,job.getLocation());
			ps.setInt(6, job.getId());
			k=ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return k;
	}
}
