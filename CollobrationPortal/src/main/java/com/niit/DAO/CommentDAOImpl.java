package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Model.Comment;



public class CommentDAOImpl implements CommentDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;

	public CommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<Comment> list() {
		@SuppressWarnings({ "unchecked" })
		List<Comment> listComment = (List<Comment>) sessionFactory.getCurrentSession().createCriteria(Comment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listComment;
	}

	public Comment get(String userId) {
		String hql = "from Comment where sender ='" + userId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Comment> listComment = (List<Comment>) query.list();
		if (listComment != null && !listComment.isEmpty()) {
			return listComment.get(0);
		}
		return null;
	}

	public void saveOrUpdate(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);

	}

	public void delete(String userId) {
		Comment commentToDelete = new Comment();
		commentToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(commentToDelete);

	}

}
