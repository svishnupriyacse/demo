package com.niit.DAO;

import java.util.List;

import com.niit.Model.Jobs;


public interface JobsDAO {

	
	public List<Jobs> list();
	
	public Jobs get(String jobId);
	
	public void saveOrUpdate(Jobs comment);
		
	public void delete(String jobId);
	
}
