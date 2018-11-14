package com.cts;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepository {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dSource){
		this.dataSource = dSource;
		this.jdbcTemplate = new JdbcTemplate(dSource);
	}
	
	public List<Subject> loadSubjects(){
		String SQL = "select * from subject" ;	
		SubjectRowMapper subMapper = new SubjectRowMapper();
		List<Subject> subjectList = (List<Subject>)jdbcTemplate.query(SQL, subMapper);
		return subjectList;
	}
	
	public void saveSubject(Subject sub){
		String SQL = "insert into subject(subTitle,durationInHours) values(?,?)";
		jdbcTemplate.update(SQL, sub.getSubtitle(), sub.getDurationInHours());
	}
	
	public void deleteSubject(long subjectId){
		String SQL = "delete from subject where subjectId = ?";
		jdbcTemplate.update(SQL, subjectId);
	}
	
	public List<Subject> searchSubject(String subTitle){
		String SQL = "select * from subject where subTitle like '%" + subTitle + "%'";
		SubjectRowMapper subMapper = new SubjectRowMapper();
		List<Subject> subjectList = (List<Subject>)jdbcTemplate.query(SQL, subMapper);
		return subjectList;
	}
}
