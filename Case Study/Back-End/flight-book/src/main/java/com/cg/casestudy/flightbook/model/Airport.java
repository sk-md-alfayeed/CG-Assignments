package com.cg.casestudy.flightbook.model;

import org.springframework.data.annotation.Id;

public class Airport {

	@Id
	private String id;
	private String airportCode;
	private String airportName;

	public Airport() {
	}

	public Airport(String id, String airportCode, String airportName) {
		super();
		this.id = id;
		this.airportCode = airportCode;
		this.airportName = airportName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

}
