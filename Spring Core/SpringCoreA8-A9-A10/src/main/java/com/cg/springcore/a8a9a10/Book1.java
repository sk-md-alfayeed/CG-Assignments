package com.cg.springcore.a8a9a10;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Book1 implements InitializingBean,DisposableBean {
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
			return "Book1 [bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
		}
		public Book1(String bookName, double bookPrice) {
			super();
			this.bookName = bookName;
			this.bookPrice = bookPrice;
		}
		public Book1() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void afterPropertiesSet() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("Taking Books Properties:Book1");
		}
		public void destroy() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("Destroying done.:Book1");
		}
		

	}


