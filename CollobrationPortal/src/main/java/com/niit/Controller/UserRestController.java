package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import com.niit.DAO.UserDao;
import com.niit.Model.User; 



@RestController
public class UserRestController {
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/customers")
	public List getCustomers() {
		return userDao.list();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		User user = userDao.get(id);
		if (user == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody User customer) {

		userDao.create(customer);

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	/*@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (userDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}*/

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody User customer) {

		customer = userDao.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

}
