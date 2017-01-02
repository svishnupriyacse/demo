package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.UserRole;




@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {

	public UserRoleDAOImpl() {
		super();
	}
	@Autowired
	private SessionFactory sessionFactory;

	
	public UserRoleDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<UserRole> list() {
		@SuppressWarnings({ "unchecked" })
		List<UserRole> listUserRole = (List<UserRole>)
		sessionFactory.getCurrentSession().createCriteria(UserRole.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserRole;
		
	}

	public UserRole get(int userId) {
		String hql = "from UserRole where username ='"+ userId +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserRole> listUserRole = (List<UserRole>) query.list();
		
		if (listUserRole != null && !listUserRole.isEmpty()){
			return listUserRole.get(0);
		}
		return null;
	}

	public void saveOrUpdate(UserRole userRole) {
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);

	}

	public void delete(int userId) {
		UserRole userRoleToDelete = new UserRole();
		userRoleToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(userRoleToDelete);

	}

}
