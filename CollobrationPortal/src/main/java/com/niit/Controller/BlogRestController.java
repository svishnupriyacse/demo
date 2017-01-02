package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.UserDao;

@RestController
public class BlogRestController {

	@Autowired
	private BlogDAO blogDao;

	public BlogDAO getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDAO blogDao) {
		this.blogDao = blogDao;
	}
	@GetMapping("/bloglist")
	public List getCustomers() {
		return blogDao.list();
	}
	
}
