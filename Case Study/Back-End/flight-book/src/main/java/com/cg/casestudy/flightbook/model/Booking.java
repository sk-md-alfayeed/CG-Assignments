package com.cg.casestudy.flightbook.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

	@Id
	private String id;
	private Flight flight;
	private List<Passenger> passengerList;
	private boolean active;
	private String userId;
	
	public Booking() {}

	public Booking(String id, Flight flight, List<Passenger> passengerList, boolean active, String userId) {
		super();
		this.id = id;
		this.flight = flight;
		this.passengerList = passengerList;
		this.active = active;
		this.userId = userId;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
