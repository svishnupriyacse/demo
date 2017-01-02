package com.niit.DAO;

import java.util.List;

import com.niit.Model.Comment;

public interface CommentDAO {

	public List<Comment> list();
	
	public Comment get(String userId);
	
	public void saveOrUpdate(Comment comment);
		
	public void delete(String userId);
}
