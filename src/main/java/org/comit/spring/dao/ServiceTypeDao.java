package org.comit.spring.dao;

import java.util.List;

import org.comit.spring.bean.ServiceType;
import org.comit.spring.dao.mapper.ServiceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
}
