package com.cts;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubjectRowMapper implements RowMapper<Subject>{
	
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException{
		long subjectId = rs.getLong("subjectId");
		String subtitle = rs.getString("subTitle");
		int durationInHours = rs.getInt("durationInHours");
		Subject subject = new Subject(subjectId, subtitle, durationInHours, null);
		return subject;
	}
}
