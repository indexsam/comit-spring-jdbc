package org.comit.spring.service;

import org.comit.spring.bean.Transaction;
import org.comit.spring.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	public Transaction transCustomer() {
		
		return this.transactionDao.transCustomer();
	}
	
	
	
}
