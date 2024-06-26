package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.Bean.*;
import com.DB.*;
public class ViewJobDAO {
	
		public ArrayList<JobBean> al = new ArrayList<JobBean>();
	public ArrayList<JobBean> retrive(){
		
		try {
			//load db-connection
			Connection con = DBConnection.getCon();
			//prepare queries to retrived data from db
			PreparedStatement ps = con.prepareStatement("select * from job order by id desc");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//ProductBean-obj
				JobBean job = new JobBean();
				//set data from ps to job
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescriPtion(rs.getString(3));
				job.setCatagory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6));
				job.setpDate(rs.getTimestamp(7)+"");
				al.add(job);//adding job to al
			}//end of loop
			//add job to arr-obj
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
//	Active jobs only
	public ArrayList<JobBean> jobs = new ArrayList<JobBean>();
	public ArrayList<JobBean> activeJobs(){
		
		try {
			//load db-connection
			Connection con = DBConnection.getCon();
			//prepare queries to retrived data from db
			PreparedStatement ps = con.prepareStatement("select * from job where status=? order by id desc");
			
			ps.setString(1, "active");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//ProductBean-obj
				JobBean job = new JobBean();
				//set data from ps to job
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescriPtion(rs.getString(3));
				job.setCatagory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6));
				job.setpDate(rs.getTimestamp(7)+"");
				jobs.add(job);//adding job to al
			}//end of loop
			//add job to arr-obj
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}
	
	//Single_job by id
	public JobBean single_job =null;
public JobBean singleJobs(int id){
		
		try {
			//load db-connection
			Connection con = DBConnection.getCon();
			//prepare queries to retrived data from db
			PreparedStatement ps = con.prepareStatement("select * from job where id=? ");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//ProductBean-obj
				JobBean job = new JobBean();
				//set data from ps to job
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescriPtion(rs.getString(3));
				job.setCatagory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6));
				job.setpDate(rs.getTimestamp(7)+"");
				single_job = job;
			}//end of loop
			//add job to arr-obj
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return single_job;
	}

//get job by _loc and cat

public ArrayList<JobBean> alljobs = new ArrayList<JobBean>();
public ArrayList<JobBean> getJobByLocORCat(String loc,String cat){
	
	try {
		//load db-connection
		Connection con = DBConnection.getCon();
		//prepare queries to retrived data from db
		PreparedStatement  ps = con.prepareStatement
				("select * from job where category=? or location=? order by id desc");
		
		
			
			ps.setString(1, cat);
			ps.setString(2, loc);
	
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			//ProductBean-obj
			JobBean job = new JobBean();
			//set data from ps to job
			job.setId(rs.getInt(1));
			job.setTitle(rs.getString(2));
			job.setDescriPtion(rs.getString(3));
			job.setCatagory(rs.getString(4));
			job.setStatus(rs.getString(5));
			job.setLocation(rs.getString(6));
			job.setpDate(rs.getTimestamp(7)+"");
			alljobs.add(job);//adding job to al
		}//end of loop
		//add job to arr-obj
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return alljobs;
}
ArrayList<JobBean> alljobs1 =new ArrayList<JobBean>();
public ArrayList<JobBean> getJobByLocAndCat(String loc, String cat) {
    
    try {
        // load db-connection
        Connection con = DBConnection.getCon();
        // prepare queries to retrieve data from db
        PreparedStatement  ps = con.prepareStatement
				("select * from job where category=? and location=? order by id desc");
		
        ps.setString(1, cat);
        ps.setString(2, loc);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            JobBean job = new JobBean();
            // set data from rs to job
            job.setId(rs.getInt(1));
            job.setTitle(rs.getString(2));
            job.setDescriPtion(rs.getString(3));
            job.setCatagory(rs.getString(4));
            job.setStatus(rs.getString(5));
            job.setLocation(rs.getString(6));
            job.setpDate(rs.getTimestamp(7) + "");
            alljobs1.add(job);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    } 
//  
    return alljobs1;
}


	
	}


