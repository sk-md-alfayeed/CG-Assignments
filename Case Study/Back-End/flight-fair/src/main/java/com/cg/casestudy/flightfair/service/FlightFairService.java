package com.cg.casestudy.flightfair.service;

import java.util.List;

import com.cg.casestudy.flightfair.model.Fair;
import com.cg.casestudy.flightfair.model.FlightList;

public interface FlightFairService {
	
	public List<Fair> getFairs(FlightList fairList);
	
	public List<Fair> getAllFairs();

}
