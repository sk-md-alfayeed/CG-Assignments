package com.cg.casestudy.flightsearch.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightsearch.model.Flight;

@Repository
public interface FlightSearchRepo extends MongoRepository<Flight, String> {
	
	List<Flight> findByDepartureAirportAndDestinationAirport(String departureAirport, String destinationAirport);
}
