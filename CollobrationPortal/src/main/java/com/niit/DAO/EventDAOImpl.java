package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Model.Event;



public class EventDAOImpl implements EventDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Event> list() {
		@SuppressWarnings({ "unchecked" })
		List<Event> listEvent = (List<Event>) sessionFactory.getCurrentSession().createCriteria(Event.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listEvent;
	}

	public Event get(String eventId) {
		String hql = "from Event where sender ='" + eventId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Event> listEvent = (List<Event>) query.list();
		if (listEvent != null && !listEvent.isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}

	public void saveOrUpdate(Event eventId) {
		sessionFactory.getCurrentSession().saveOrUpdate(eventId);

	}

	public void delete(String eventId) {
		Event commentToDelete = new Event();
		commentToDelete.setEventId(eventId);
		sessionFactory.getCurrentSession().delete(commentToDelete);

	}

}
