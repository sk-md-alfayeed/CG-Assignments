package flightsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import flightsearch.model.Flight;
import flightsearch.model.Search;
import flightsearch.service.FlightSearchServiceImpl;

@RestController
public class FlightSearchController {

	@Autowired
	private FlightSearchServiceImpl flightSearchServiceImpl;

	@GetMapping(value = "/flights")
	public List<Flight> getFlights(@RequestBody Search search) {

		return flightSearchServiceImpl.getFlights(search);
	}
	
	@GetMapping(value = "/allFlights")
	public List<Flight> getAllFlights() {

		return flightSearchServiceImpl.getAllFlights();
	}
	
	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flight) {
		flightSearchServiceImpl.saveFlight(flight);
		return "Added Flight with id : " + flight.getId();
	}

	@GetMapping("/findFlight/{id}")
	public Optional<Flight> getFlight(@PathVariable String id) {
		return flightSearchServiceImpl.getFlight(id);
	}

	@DeleteMapping("/deleteFlight/{id}")
	public String deleteBook(@PathVariable String id) {
		flightSearchServiceImpl.deleteFlight(id);
		return "Flight Deleted with id : " + id;
	}
	

}
