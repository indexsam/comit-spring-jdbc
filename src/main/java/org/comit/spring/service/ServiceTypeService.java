package org.comit.spring.service;

import java.util.List;
import org.comit.spring.bean.ServiceType;
import org.comit.spring.dao.ServiceTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService {

	@Autowired
	ServiceTypeDao servicetypeDao;
	
	public List<ServiceType> listServiceTypeBridal() {
		
		return this.servicetypeDao.listServiceTypeBridal();
	}
	
	public List<ServiceType> listServiceTypeWinter() {
		
		return this.servicetypeDao.listServiceTypeWinter();
	}
	
	public List<ServiceType> listServiceTypeSummer() {
		
		return this.servicetypeDao.listServiceTypeSummer();
	}
	
	public void findItem(int iditem) {
		
		this.servicetypeDao.findItem(iditem);
		
	}
	
	public void deleteItem() {
		
		this.servicetypeDao.deleteItem();
		
	}
	
	
}
