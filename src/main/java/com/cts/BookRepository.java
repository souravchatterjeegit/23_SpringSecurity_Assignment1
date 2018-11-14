package com.cts;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dSource){
		this.dataSource = dSource;
		this.jdbcTemplate = new JdbcTemplate(dSource);
	}
	
	public List<Book> loadBooks(){
		String SQL = "select * from book" ;	
		BookRowMapper bookMapper = new BookRowMapper();
		List<Book> bookList = (List<Book>)jdbcTemplate.query(SQL, bookMapper);
		return bookList;
	}
	
	public List<Subject> loadSubjects(){
		String SQL = "select * from subject" ;	
		SubjectRowMapper subMapper = new SubjectRowMapper();
		List<Subject> subjectList = (List<Subject>)jdbcTemplate.query(SQL, subMapper);
		return subjectList;
	}
	
	public void saveBook(Book book,long subjectId){
		String SQL = "insert into book(title,price,volume,publishDate,subjectId) values(?,?,?,?,?)";
		jdbcTemplate.update(SQL, book.getTitle(), book.getPrice(), book.getVolume(), book.getPublishDate(), subjectId);
	}
	
	public void deleteBook(long bookId){
		String SQL = "delete from book where bookId = ?";
		jdbcTemplate.update(SQL, bookId);
	}
	
	public List<Book> searchBook(String bookTitle){
		String SQL = "select * from book where title like '%" + bookTitle + "%'";
		BookRowMapper bookMapper = new BookRowMapper();
		List<Book> bookList = (List<Book>)jdbcTemplate.query(SQL, bookMapper);
		return bookList;
	}
}
