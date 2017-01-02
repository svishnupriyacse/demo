package com.niit.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "userrole")
@Component
public class UserRole {

	@Id
	@GeneratedValue (generator = "newGenetrator")  //name of the primary key generator.
	@GenericGenerator (name = "newGenetrator", strategy = "foreign", parameters = {@Parameter(value = "user", name="property")})
	private int userId;
	
	private int roleId;   
  
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
    
}
