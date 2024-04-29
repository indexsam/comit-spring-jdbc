package org.comit.spring.service;

import org.comit.spring.bean.Customer;
import org.comit.spring.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public void createUser(Customer customer){
		
		// only those registered with encrypted password can log in (encrypted from config.WebSecurityConfig.java
		 customer.setPassword(this.passwordEncoder.encode(customer.getPassword())); // enable encryption of password 
			
		   this.customerDao.createUser(customer);
		}

	public Customer findUserEmail(Customer customer){
		
		return this.customerDao.findUserEmail(customer);
	}
	
	public Customer findUserPhone(Customer customer){
		
		return this.customerDao.findUserPhone(customer);
	}
		
	    public String idU() {
			
	    	return this.customerDao.idU();

		}
		
}
