package flightsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightsearch.dao.FlightSearchRepo;
import flightsearch.model.Flight;
import flightsearch.model.Search;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	@Autowired
	private FlightSearchRepo flightSearchRepo;
	
	public List<Flight> getFlights(Search search) {
		
		return flightSearchRepo.findByDepartureAirportAndDestinationAirport(search.getDepartureAirport(), search.getDestinationAirport());
		
	}

	public List<Flight> getAllFlights() {
		return flightSearchRepo.findAll();
		
	}

	public String deleteFlight(String id) {
		flightSearchRepo.deleteById(id);
		return "Flight deleted with id : " + id;
	}

	public Optional<Flight> getFlight(String id) {
		return flightSearchRepo.findById(id);
	}

	public String saveFlight(Flight flight) {
		flightSearchRepo.save(flight);
		return "Added  with id : " + flight.getId();
	}


}
