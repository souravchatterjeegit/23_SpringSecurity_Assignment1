package com.cts;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialRepository {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dSource){
		this.dataSource = dSource;
		this.jdbcTemplate = new JdbcTemplate(dSource);
	}
	
	public void saveUser(String userId, String password, String[] roles){
		String SQL = "insert into users(username,password) values(?,?)";
		jdbcTemplate.update(SQL, userId, password);
		for(int i=0;i<roles.length;i++){
			String SQL1 = "insert into authorities(username, authority) values(?,?);";
			jdbcTemplate.update(SQL1, userId, roles[i]);
		}
		
	}
}
