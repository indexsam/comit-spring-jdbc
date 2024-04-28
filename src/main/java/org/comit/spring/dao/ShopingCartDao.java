package org.comit.spring.dao;

import java.util.List;

import org.comit.spring.bean.ShopingCart;
import org.comit.spring.dao.mapper.ShopingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopingCartDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ShopingCart> listShopingCart(){
		
		
		// pick only the  columns the map to the bean variables  ( sometime they all map , then use select *)
		String sql = "SELECT ID_SHOPING_CART, TYPE, SERVICE_NAME, COST FROM SHOPING_CART";
		
		return this.jdbcTemplate.query(sql, new ShopingCartMapper());
	}
	
	
	
		
		
	
}
