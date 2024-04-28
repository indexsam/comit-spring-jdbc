package org.comit.spring.dao;


import java.time.LocalDateTime;
import java.util.List;

import org.comit.spring.bean.Customer;
import org.comit.spring.bean.ServiceType;
import org.comit.spring.dao.mapper.CustomerMapper;
import org.comit.spring.dao.mapper.ServiceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceTypeDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ServiceType> listServiceTypeBridal(){
		
		String sql = "SELECT * FROM SERVICE_TYPE WHERE TYPE = 'bridal' AND STATUS ='available'";
		
		return this.jdbcTemplate.query(sql, new ServiceTypeMapper());
	}
	
	
	
		public List<ServiceType> listServiceTypeWinter(){
		
		String sql = "SELECT * FROM SERVICE_TYPE WHERE TYPE = 'winter' AND STATUS ='available'";
		
		return this.jdbcTemplate.query(sql, new ServiceTypeMapper());
	}
	
		public List<ServiceType> listServiceTypeSummer(){
		
		String sql = "SELECT * FROM SERVICE_TYPE WHERE TYPE = 'summer' AND STATUS ='available'";
		
		return this.jdbcTemplate.query(sql, new ServiceTypeMapper());
		
	}
		
		  // DataAccessUtils.singleResult for SELECT, while jdbc pure is for update and delete
		
		public void findItem(int iditem){
		   		
		   		String sql = "SELECT * FROM SERVICE_TYPE WHERE ID_SERVICE_TYPE = ?";
		   		String sql2 = "INSERT INTO SHOPING_CART (TYPE, SERVICE_NAME, COST, DATE_TIME, CUSTOMER_ID_CUSTOMER, SERVICE_TYPE_ID_SERVICE_TYPE) " 
			               + "VALUES(?,?,?,?,?,?)";
		   		   		
		   		 
		   		 
		   	     Customer user = this.loggedUser(this.idU());
		   	     
		   	     System.out.println("User ID:  is NOT NULL IN DAO " + user.getIdCustomer());
		   	     
		   	     ServiceType serve =  DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new ServiceTypeMapper(), iditem));
		   	     
		     	 LocalDateTime currentDateTime = LocalDateTime.now();
		     	 
		     	 
		        this.jdbcTemplate.update(sql2, serve.getType(),serve.getServiceName(), serve.getCost(), currentDateTime,  user.getIdCustomer(), serve.getIdServiceType());
		   	    
		   	   		   	
		   	 }
		   
		       
		      public Customer loggedUser(String str){
		   		
		   		String sql = "SELECT ID_CUSTOMER, CUSTOMER_NAME,EMAIL, PHONE_NUMBER, PASSWORD, HOME_ADDRESS,POST_CODE FROM CUSTOMER WHERE EMAIL = ?";
		   		
		   		return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new CustomerMapper(), str));
		   		
		   	 }
		   
		   
		      public String idU() {
				 // Inside your method or class where you need the user's ID
				    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				

				        String userId = authentication.getName();
				        // Now you have the user's ID
				        System.out.println("User ID:  in Dao " + userId);
				        
				        LocalDateTime currentDateTime = LocalDateTime.now();
				        System.out.println("Local Date Time:  in Dao" + currentDateTime);
				        
				         return userId;
		       }

		   
		   
		   
		
	
}
