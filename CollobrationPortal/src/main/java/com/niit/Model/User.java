package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "User")
@Component
public class User {
	
	@Id
	@GeneratedValue
	private long user_id;
	private String userName;
	private int type_of_user;
	private String email_id;
	private long phone_no;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	public User(int user_id, String userName, int type_of_user, String email_id, long phone_no,String password) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.type_of_user = type_of_user;
		this.email_id = email_id;
		this.phone_no = phone_no;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long l) {
		this.user_id = l; 
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getType_of_user() {
		return type_of_user;
	}
	public void setType_of_user(int type_of_user) {
		this.type_of_user = type_of_user;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	
}
