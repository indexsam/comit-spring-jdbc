package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.ShopingCart;
import org.springframework.jdbc.core.RowMapper;

public class ShopingCartMapper implements RowMapper<ShopingCart> {
	
	@Override
	public ShopingCart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ShopingCart shopingcart = new ShopingCart();
		
		shopingcart.setIdShopingCart(rs.getInt("ID_SHOPING_CART"));
		shopingcart.setType(rs.getString("TYPE"));
		shopingcart.setServiceName(rs.getString("SERVICE_NAME"));
		shopingcart.setCost(rs.getDouble("COST"));
		
		
		
		return shopingcart;
	}
	
}
