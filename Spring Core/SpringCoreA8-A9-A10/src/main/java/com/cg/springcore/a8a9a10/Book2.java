package com.cg.springcore.a8a9a10;

public class Book2 {
	private String bookName;
	private double bookPrice;
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
		return "Book2 [bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	public Book2(String bookName, double bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public Book2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init()
	{
		System.out.println("Init method calling: Book2");
	}
	public void destroy()
	{
		System.out.println("Destroy method:Book2");
	}
}
