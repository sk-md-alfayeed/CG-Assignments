package com.cg.springcore.a8a9a10;

import javax.annotation.*;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Book3 implements ApplicationContextAware{
	private String bookName;
	private double bookPrice;
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext=null;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book3 [bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	public Book3(String bookName, double bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public Book3() {
		super();
		
	}
	@PostConstruct
	public void start()
	{
		System.out.println("Using @PostConstruct:Book3");
	}
	@PreDestroy
	public void end()
	{
		System.out.println("Using @PreDestroy:Book3");
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	
		this.applicationContext=applicationContext;
	}
}
