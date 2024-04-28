package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.Order;
import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order> {
	
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		
		order.setIdOrder(rs.getInt("ID_SHOPING_CART"));
		order.setType(rs.getString("TYPE"));
		order.setServiceName(rs.getString("SERVICE_NAME"));
		order.setCost(rs.getDouble("COST"));
		
		
		
		return order;
	}
	
}
