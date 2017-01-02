package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Model.Blog;

public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Blog> list() {
		@SuppressWarnings({ "unchecked" })
		List<Blog> listBlog = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;
	}
	@Transactional
	public Blog get(String blogName) {
		String hql = "from Blog where blogName ='" + blogName + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}
	@Transactional
	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}
	@Transactional
	public void delete(String blogId) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);

	}

}
