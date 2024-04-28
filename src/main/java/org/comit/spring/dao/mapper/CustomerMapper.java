package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.Customer;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer customer = new Customer();
		
		customer.setIdCustomer(rs.getInt("ID_CUSTOMER"));
		customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
		customer.setEmail(rs.getString("EMAIL"));
		customer.setPhoneNumber(rs.getString("PHONE_NUMBER"));
		customer.setPassword(rs.getString("PASSWORD"));
		customer.setHomeAddress(rs.getString("HOME_ADDRESS"));
		customer.setPostCode(rs.getString("POST_CODE"));
		//customer.setCreatedDate(rs.getDate("CREATED_DATE"));
		
		return customer;
	}

}
