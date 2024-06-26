package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.JobBean;
import com.DB.DBConnection;

public class EditJobDAO {
	public JobBean job=null;
	public JobBean editJob(int id) {
		
		try {
			Connection con = DBConnection.getCon();
			//connection from data-base
			PreparedStatement ps = con.prepareStatement
					("select * from job where id=?");
		    //preparedStatement
			
			//setting data to preparedStatement obj
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				job = new JobBean();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescriPtion(rs.getString(3));
				job.setCatagory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6));
				
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return job;
}
}
