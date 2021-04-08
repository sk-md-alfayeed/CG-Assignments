package com.cg.casestudy.flightfair.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fair {
	
	@Id
	String id;
	String flightId;
	String flightName;
	Integer flightFair;
	
	public Fair() {}
	

	public Fair(String id, String flightId, String flightName, Integer flightFair) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightFair = flightFair;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFlightId() {
		return flightId;
	}


	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}


	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public Integer getFlightFair() {
		return flightFair;
	}


	public void setFlightFair(Integer flightFair) {
		this.flightFair = flightFair;
	}

}
