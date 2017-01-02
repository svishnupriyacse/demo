package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Model.FriendList;



public class FriendListDAOImpl implements FriendListDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	public FriendListDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<FriendList> list() {
		@SuppressWarnings({ "unchecked" })
		List<FriendList> listFriendList = (List<FriendList>) sessionFactory.getCurrentSession().createCriteria(FriendList.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listFriendList;
	}

	public FriendList get(String friendId) {
		String hql = "from FriendList where sender ='" + friendId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FriendList> listFriendList = (List<FriendList>) query.list();
		if (listFriendList != null && !listFriendList.isEmpty()) {
			return listFriendList.get(0);
		}
		return null;
	}

	public void saveOrUpdate(FriendList friendList) {
		sessionFactory.getCurrentSession().saveOrUpdate(friendList);

	}

	public void delete(String friendId) {
		FriendList friendListToDelete = new FriendList();
		friendListToDelete.setFriendId(friendId);
		sessionFactory.getCurrentSession().delete(friendListToDelete);
	}

}
