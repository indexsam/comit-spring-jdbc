package org.comit.spring.service;

import org.comit.spring.bean.PickUp;
import org.comit.spring.dao.PickUpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PickUpService {

	@Autowired
	PickUpDao pickupDao;
	
	@Transactional
	public  void  createPickup(PickUp pickup) {
		
		this.pickupDao.createPickup(pickup);
	}
	
	
	
}
