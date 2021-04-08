package com.cg.casestudy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.casestudy.flightsearch.FlightSearchServiceApplication;
import com.cg.casestudy.flightsearch.model.Airline;
import com.cg.casestudy.flightsearch.model.Airport;
import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.Search;
import com.cg.casestudy.flightsearch.repository.FlightSearchRepository;
import com.cg.casestudy.flightsearch.service.FlightSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightSearchServiceApplication.class)
class FlightSearchServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private FlightSearchService service;

	@MockBean
	private FlightSearchRepository repository;

	@Test
	public void getFlightsTest() {

		when(repository.findByDepartureAirportAirportCodeAndDestinationAirportAirportCode("DEL", "BOM")).thenReturn(Stream
				.of(new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 100),
						new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 150))
				.collect(Collectors.toList()));
		assertEquals(2, service.getFlights(new Search("DEL", "BOM")).size());
	}

	@Test
	public void getAllFlightsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 100),
						new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 150))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllFlights().size());
	}

	@Test
	public void addFlightTest() {
		Flight flight = new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 100);
		when(repository.save(flight)).thenReturn(flight);
		assertEquals("Flight Added  with id : " + flight.getId(), service.addFlight(flight));
	}

	@Test
	public void deleteFlightTest() {
		Flight flight = new Flight("DM105", new Airline("", "", ""), new Airport("","",""), new Airport("","",""), "21-04-2021", "21-04-2021", "22:20", "00.20", 100);
		service.deleteFlight(flight.getId());
		verify(repository, times(1)).deleteById(flight.getId());
	}

}
