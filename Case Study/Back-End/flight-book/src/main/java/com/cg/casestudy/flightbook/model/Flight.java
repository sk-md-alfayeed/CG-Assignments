package com.cg.casestudy.flightbook.model;

import org.springframework.data.annotation.Id;

public class Flight {

	@Id
	private String id;
	private Airline airline;
	private Airport departureAirport;
	private Airport destinationAirport;
	private String departureDate;
	private String arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private Integer seats;
	private Integer flightFair;

	public Flight() {
	}

	public Flight(String id, Airline airline, Airport departureAirport, Airport destinationAirport,
			String departureDate, String arrivalDate, String departureTime, String arrivalTime, Integer seats,
			Integer flightFair) {
		super();
		this.id = id;
		this.airline = airline;
		this.departureAirport = departureAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seats = seats;
		this.flightFair = flightFair;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
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

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getFlightFair() {
		return flightFair;
	}

	public void setFlightFair(Integer flightFair) {
		this.flightFair = flightFair;
	}

}
