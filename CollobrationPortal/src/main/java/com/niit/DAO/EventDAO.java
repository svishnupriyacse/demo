package com.niit.DAO;

import java.util.List;

import com.niit.Model.Event;

public interface EventDAO {

	
	public List<Event> list();
	
	public Event get(String eventId);
	
	public void saveOrUpdate(Event eventId);
		
	public void delete(String eventId);
}
