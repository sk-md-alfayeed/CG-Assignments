package com.cg.casestudy.flightfair.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.casestudy.flightfair.model.Fair;
import com.cg.casestudy.flightfair.model.FlightFair;
import com.cg.casestudy.flightfair.model.FlightList;

@Service
public interface FlightFairService {
	
	public FlightFair getFairs(FlightList fairList);
	
	public List<Fair> getAllFairs();
	
	public Optional<Fair> getFair(String flightId);
	
	public String addFair(Fair fair);
	
	public String updateFair(Fair fair);
	
	public String deleteFair(String id);

	public String deleteFairByFlightId(String flightId);

}
