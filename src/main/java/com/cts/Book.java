package com.cts;
import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	long bookId;
	String title;
	double price;
	int volume;
	Date publishDate;
	
	public Book(){
		super();
	}

	public Book(long bookId, String title, double price, int volume,
			Date publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price="
				+ price + ", volume=" + volume + ", publishDate=" + publishDate
				+ "]";
	}	
	
}
