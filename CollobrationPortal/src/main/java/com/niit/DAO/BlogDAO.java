package com.niit.DAO;

import java.util.List;

import com.niit.Model.Blog;
public interface BlogDAO {

	public List<Blog> list();
	
	public Blog get(String blogName);
	
	public void saveOrUpdate(Blog blog);
		
	public void delete(String blogId);
}
