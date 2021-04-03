package com.cg.casestudy.flightsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.flightsearch.dao.FlightSearchRepository;
import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.Search;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	@Autowired
	private FlightSearchRepository flightSearchRepo;

	@Autowired
	private RestTemplate restTemplate;

//	FlightList flightList = new FlightList();

	private List<Flight> searchedList;

	// Get flights by custom search
	public List<Flight> getFlights(Search search) {

		//Custom search 
		searchedList = flightSearchRepo.findByDepartureAirportAndDestinationAirport(search.getDepartureAirport(),
				search.getDestinationAirport());
		
		// making list of flightIds
//		flightList.setFlightList(searchedList.stream().map(Flight::getId).collect(Collectors.toList()));
		return searchedList;
	}

	// Getting All Flight
	@Override
	public List<Flight> getAllFlights() {

		return flightSearchRepo.findAll();
	}

	// Getting the Flight
	@Override
	public Optional<Flight> getFlight(String id) {
		return flightSearchRepo.findById(id);
	}

	// Adding the Flight
	@Override
	public String addFlight(Flight flight) {
		flightSearchRepo.save(flight);
		return "Flight Added  with id : " + flight.getId();
	}

	// Updating the Flight
	@Override
	public String updateFlight(Flight flight) {
		flightSearchRepo.save(flight);
		return "Flight Updated  with id : " + flight.getId();
	}

	// Deleting the Flight
	@Override
	public String deleteFlight(String flightId) {
		flightSearchRepo.deleteById(flightId);
		try {
			// Deleting the Fair from Flight Fair Microservice while this deleteFlight method is called
			restTemplate.delete("http://flight-fair/deleteFair/" + flightId);
		} catch (Exception e) {
			return "Flight deleted with Flight Id : " + flightId;
		}
		return "Flight deleted with Flight Id : " + flightId;
	}

}
