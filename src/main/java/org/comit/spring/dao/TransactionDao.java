package org.comit.spring.dao;



import org.comit.spring.bean.Customer;
import org.comit.spring.bean.Transaction;
import org.comit.spring.dao.mapper.CustomerMapper;
import org.comit.spring.dao.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Transaction transCustomer(){
		
		
		
		String sql = "SELECT ID_TRANSACTION, TOTAL FROM TRANSACTION WHERE DATE_TIME =(SELECT MAX(DATE_TIME) FROM "
				+ "TRANSACTION WHERE CUSTOMER_ID_CUSTOMER = ?)";
				    
		
		Customer user = this.loggedUser(this.idU());
		
		return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new TransactionMapper(), user.getIdCustomer()));
	}
	
	
	    
	
	public Customer loggedUser(String str) {
	   		
	   		String sql = "SELECT ID_CUSTOMER, CUSTOMER_NAME,EMAIL, PHONE_NUMBER, PASSWORD, HOME_ADDRESS,POST_CODE FROM CUSTOMER WHERE UPPER(EMAIL) = UPPER(?)";
	   		
	   		return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new CustomerMapper(), str));
	   		
	   	 }
	   
	   
	      public String idU() {
			 // Inside your method or class where you need the user's ID
			    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			        String userId = authentication.getName();
			     		        
			         return userId;
	       }

		
		
	
}
