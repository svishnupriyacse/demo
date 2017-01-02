package com.niit.DAO;

import java.util.List;

import com.niit.Model.Chat;

public interface ChatDAO {

	public List<Chat> list();
	
	public Chat get(String sender);
	
	public void saveOrUpdate(Chat chat);
		
	public void delete(String sender);
}
