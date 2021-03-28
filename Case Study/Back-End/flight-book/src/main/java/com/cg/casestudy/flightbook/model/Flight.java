package com.cg.casestudy.flightbook.model;

import org.springframework.data.annotation.Id;

public class Flight {

	@Id
	private String id;
	private String flightName;
	private String departureAirport;
	private String destinationAirport;
	private String departureDate;
	private String arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private Integer flightFair;

	public Flight() {
	}

	public Flight(String id, String flightName, String departureAirport, String destinationAirport,
			String departureDate, String arrivalDate, String departureTime, String arrivalTime, Integer flightFair) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.departureAirport = departureAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightFair = flightFair;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getFlightFair() {
		return flightFair;
	}

	public void setFlightFair(Integer flightFair) {
		this.flightFair = flightFair;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", departureAirport=" + departureAirport
				+ ", destinationAirport=" + destinationAirport + ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", flightFair="
				+ flightFair + "]";
	}

	
}
