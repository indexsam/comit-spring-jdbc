package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.ServiceType;
import org.springframework.jdbc.core.RowMapper;

public class ServiceTypeMapper implements RowMapper<ServiceType> {
	
	@Override
	public ServiceType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ServiceType servicetype = new ServiceType();
		
		servicetype.setIdServiceType(rs.getInt("ID_SERVICE_TYPE"));
		servicetype.setType(rs.getString("TYPE"));
		servicetype.setServiceName(rs.getString("SERVICE_NAME"));
		servicetype.setCost(rs.getDouble("COST"));
		servicetype.setStatus(rs.getString("STATUS"));
		
		
		return servicetype;
	}
	
}
