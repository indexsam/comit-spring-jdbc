package org.comit.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.spring.bean.Transaction;
import org.springframework.jdbc.core.RowMapper;

public class TransactionMapper implements RowMapper<Transaction> {
	
	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transaction trans = new Transaction();
		
		trans.setIdTransaction(rs.getInt("ID_TRANSACTION"));
		trans.setTotal(rs.getDouble("TOTAL"));
		
	
		
		
		
		return trans;
	}
	
}
