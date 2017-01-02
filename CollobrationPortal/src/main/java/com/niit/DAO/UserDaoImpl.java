package com.niit.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.Model.User;
@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List list() {
		// TODO Auto-generated method stub
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<User> listUser = (List<User>)
		sessionFactory.getCurrentSession().createCriteria(User.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
		
	}

	
	@Transactional	
	public User create(User users) {
		// TODO Auto-generated method stub
		users.setUser_id(1);
		users.setUserName("paramesh");
		users.setType_of_user(2);
		users.setEmail_id("svishnupriyacse@gmail.com");
		users.setPhone_no(1222222);
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		return users;
	}
	@Transactional	
	public void delete(Long id) {
		User userToDelete = new User();
		userToDelete.setUser_id(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}
	@Transactional	
	public User update(Long id, User users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		return users;
	}
	@Transactional	
	public User get(Long id) {
		String hql = "from user where user_Id =" + "'"+ id +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
}
}