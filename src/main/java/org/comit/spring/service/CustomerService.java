package org.comit.spring.service;

import org.comit.spring.bean.Customer;
import org.comit.spring.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	public void createUser(Customer customer){
			
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
