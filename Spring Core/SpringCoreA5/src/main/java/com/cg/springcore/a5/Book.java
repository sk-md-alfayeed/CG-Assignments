package com.cg.springcore.a5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class Book {
	private String bookName;
	private int price;
	
	
	@Resource
	private Author author;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Resource
	private Publisher publisher;

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}
	@Required
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Book() {

	}
	public Book(String bookName, int price, Author author, Publisher publisher) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", price=" + price + ", author=" + author + ", publisher=" + publisher
				+ "]";
	}

}
