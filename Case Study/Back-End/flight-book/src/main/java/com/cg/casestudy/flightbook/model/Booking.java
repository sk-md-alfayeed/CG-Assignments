package com.cg.casestudy.flightbook.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	
	private String id;
	private Flight flight;
	private List<Passenger> passengerList;
	boolean active;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
