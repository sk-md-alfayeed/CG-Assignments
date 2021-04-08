package com.cg.casestudy.flightbook.model;

import org.springframework.data.annotation.Id;


public class Airline {

	@Id
	private String id;
	private String airlineNo;
	private String airlineName;

	public Airline() {
	}

	public Airline(String id, String airlineNo, String airlineName) {
		super();
		this.id = id;
		this.airlineNo = airlineNo;
		this.airlineName = airlineName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAirlineNo() {
		return airlineNo;
	}

	public void setAirlineNo(String airlineNo) {
		this.airlineNo = airlineNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	};

}
