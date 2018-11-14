package com.cts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book>{
	
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException{
		long bookId = rs.getLong("bookId");
		String title = rs.getString("title");
		double price = rs.getDouble("price");
		int volume = rs.getInt("volume");
		Date publishDate = rs.getDate("publishDate");
		Book book = new Book(bookId, title, price, volume, publishDate);
		return book;
	}
}
