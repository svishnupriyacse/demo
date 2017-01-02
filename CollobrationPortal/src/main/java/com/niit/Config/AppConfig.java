package com.niit.Config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.DAO.BlogDAOImpl;
import com.niit.DAO.UserDaoImpl;
import com.niit.Model.Blog;
import com.niit.Model.Chat;
import com.niit.Model.Comment;
import com.niit.Model.Event;
import com.niit.Model.FriendList;
import com.niit.Model.Jobs;
import com.niit.Model.User;
import com.niit.Model.UserRole;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.niit")
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/Collaboration");
		
		dataSource.setUsername("sa");
		dataSource.setPassword(" ");
		
		return dataSource;
		}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.default_schema", "vishnu");
		properties.put("hibernate.generate_statistics", "true");
		properties.put("hibernate.archive.autodetection", "class");
		return properties;
		}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Chat.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(FriendList.class);
		sessionBuilder.addAnnotatedClass(Jobs.class);
		sessionBuilder.addAnnotatedClass(UserRole.class);
		
		return sessionBuilder.buildSessionFactory();
		}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
	@Autowired(required=true)
	@Bean(name="userDao")
	public UserDaoImpl getUserDaoImpl(SessionFactory sessionFactory){
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired(required=true)
	@Bean(name="blogDao")
	public BlogDAOImpl getBlogDAOImpl(SessionFactory sessionFactory){
		return new BlogDAOImpl(sessionFactory);
	}

	

}
