package flightsearch.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import flightsearch.model.Flight;

@Repository
public interface FlightSearchRepo extends MongoRepository<Flight, String> {

//	@Query(value = "db.FLIGHT.find({\r\n"
//			+ "\r\n"
//			+ "   \"$and\": [{\r\n"
//			+ "   \"$where\": \"this.departure_Airport == this.:departureAirport \"\r\n"
//			+ " },{ \"$where\": \"this. destination_Airport == this.:destinationAirport\"\r\n"
//			+ "   }]\r\n"
//			+ "});")
//	List<Flight> findByDepaDest(@Param("departureAirport") String departureAirport,
//			@Param("destinationAirport") String destinationAirport);
	
	List<Flight> findByDepartureAirportAndDestinationAirport(String departureAirport, String destinationAirport);
}
