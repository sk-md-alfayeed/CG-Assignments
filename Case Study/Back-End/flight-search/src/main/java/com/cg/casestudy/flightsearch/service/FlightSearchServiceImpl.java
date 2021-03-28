package com.cg.casestudy.flightsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.flightsearch.dao.FlightSearchRepo;
import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.FlightList;
import com.cg.casestudy.flightsearch.model.Search;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	@Autowired
	private FlightSearchRepo flightSearchRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	FlightList flightList = new FlightList();

	private List<Flight> searchedList;
	

	public List<Flight> getFlights(Search search) {

		searchedList = flightSearchRepo.findByDepartureAirportAndDestinationAirport(search.getDepartureAirport(),
				search.getDestinationAirport());

//		flightList.setFlightList(searchedList.stream().map(Flight::getId).collect(Collectors.toList()));
//
//		System.out.println(flightList.getFlightList());
//
//		FlightFair flightFair = restTemplate.postForObject("http://localhost:8082/fairs", flightList, FlightFair.class);
//
//		System.out.println(flightFair.getFlightFair());

		return searchedList;
	}

	@Override
	public List<Flight> getAllFlights() {

		return flightSearchRepo.findAll();
	}

	public String saveFlight(Flight flight) {
		flightSearchRepo.save(flight);
		return "Added  with id : " + flight.getId();
	}
	
	public String updateFlight(Flight flight) {
		flightSearchRepo.save(flight);
		return "Updated  with id : " + flight.getId();
	}

	public Optional<Flight> getFlight(String id) {
		return flightSearchRepo.findById(id);
	}

	public String deleteFlight(String flightId) {
		flightSearchRepo.deleteById(flightId);
		try {
			restTemplate.delete("http://localhost:8082/deleteFair/" + flightId);
			System.out.println("___________Fair Deleted");
			}
			catch(Exception e) {
				System.out.println("___________Fair Not Available");
				return "Flight deleted with Flight Id : " + flightId;
			}
		return "Flight deleted with Flight Id : " + flightId;
	}

}
