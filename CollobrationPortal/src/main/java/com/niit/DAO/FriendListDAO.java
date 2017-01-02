package com.niit.DAO;

import java.util.List;

import com.niit.Model.FriendList;

public interface FriendListDAO {

	public List<FriendList> list();
	
	public FriendList get(String friendId);
	
	public void saveOrUpdate(FriendList friendList);
		
	public void delete(String friendId);
	
	
}
