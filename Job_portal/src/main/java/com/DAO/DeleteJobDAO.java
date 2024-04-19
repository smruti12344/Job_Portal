package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.JobBean;
import com.DB.DBConnection;

public class DeleteJobDAO {
	public int k=0;
	public int deleteJob(JobBean job) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("delete from job  where id=?");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			
			ps.setInt(1, job.getId());
			k=ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return k;
	}
}
