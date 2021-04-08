package com.cg.casestudy.flightbook.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userInformations")
public class UserInformation {
	
	
	@Id
	private String username; 
	private List<Booking> bookingList;
	
	public UserInformation() {}
	
	public UserInformation(String username, List<Booking> bookingList) {
		super();
		this.username = username;
		this.bookingList = bookingList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	
	
	
	
	
	

}
