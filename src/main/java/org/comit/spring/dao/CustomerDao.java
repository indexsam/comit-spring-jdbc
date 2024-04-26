package org.comit.spring.dao;

import org.comit.spring.bean.Customer;
import org.comit.spring.dao.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

    public void createUser(Customer customer){
		
		String sql = "INSERT INTO CUSTOMER (CUSTOMER_NAME, EMAIL, PHONE_NUMBER,"
				+ " PASSWORD, HOME_ADDRESS, POST_CODE, CREATED_DATE) " 
	               + "VALUES(?,?,?,?,?,?,?)";
		
		this.jdbcTemplate.update(sql, customer.getCustomerName(), customer.getEmail(), 
				  customer.getPhoneNumber(), 
				customer.getPassword(), customer.getHomeAddress(),
				customer.getPostCode(), customer.getCreatedDate());
	}
    
        // for validating Email via binding in controller
		public Customer findUserEmail(Customer customer){
				
				String sql = "SELECT * FROM CUSTOMER WHERE ID_CUSTOMER != ? AND UPPER(EMAIL) = UPPER(?)";
				
				return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new CustomerMapper(), 
						                   customer.getIdCustomer(), customer.getEmail()));
				}
		// for validating phone numbers via binding in controller
		public Customer findUserPhone(Customer customer){
			
			String sql = "SELECT * FROM CUSTOMER WHERE ID_CUSTOMER != ? AND PHONE_NUMBER = ? ";
			
			return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new CustomerMapper(), 
					                   customer.getIdCustomer(), customer.getPhoneNumber()));
			}
		
		// strictly for security (NOTE: String input)-> doesn't flow back to controller
		public Customer findUserEmail(String email){
			
			String sql = "SELECT * FROM CUSTOMER WHERE UPPER(EMAIL) = UPPER(?)";
			
			return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new CustomerMapper(),email));
		}
		
		
		
}
