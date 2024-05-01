package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.Order;
import org.comit.spring.bean.PickUp;
import org.springframework.jdbc.core.RowMapper;

public class PickUpMapper implements RowMapper<PickUp> {
	
	@Override
	public PickUp mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PickUp pick = new PickUp();
		
		pick.setIdserviceRequest(rs.getInt("ID_SERVICE_REQUEST"));
		pick.setPickupDate(rs.getString("PICKUP_DATE"));
		pick.setPickupTime(rs.getString("PICKUP_TIME"));
		pick.setAmPm(rs.getString("AM_PM"));
		pick.setDeliveryTime(rs.getString("DELIVERY_DATE"));
		
		
		
		return pick;
	}
	
}
