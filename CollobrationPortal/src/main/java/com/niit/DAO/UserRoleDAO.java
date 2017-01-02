package com.niit.DAO;

import java.util.List;

import com.niit.Model.UserRole;



public interface UserRoleDAO {

	public List<UserRole> list();
	
	public UserRole get(int userId);
	
	public void saveOrUpdate(UserRole userRole);
		
	public void delete(int userId);
}
