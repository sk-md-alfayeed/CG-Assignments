import axios from "axios";

//Right Now global API gateway "http://localhost:9090"is not stable, thats why I am using original ports

//Flight Search Microservice
const FLIGHT_SEARCH_REST_API_URL = "http://localhost:8081/flight";

//Flight Search Microservice
const FLIGHT_SEARCH_AIRLINE_REST_API_URL =
  "http://localhost:8081/flight/airline";

//Flight Search Microservice
const FLIGHT_SEARCH_AIRPORT_REST_API_URL =
  "http://localhost:8081/flight/airport";

//Flight Fare Microservice
const FLIGHT_FARE_REST_API_URL = "http://localhost:8082/fare";

//Flight Book Microservice
const FLIGHT_BOOK_REST_API_URL = "http://localhost:8083/booking";

//Flight Book Microservice
const FLIGHT_CHECKIN_REST_API_URL = "http://localhost:8084/checkin";

class FlightSearchService {
  //Flight Search Microservice
  getFlights(search) {
    return axios.post(FLIGHT_SEARCH_REST_API_URL + "/flights", search);
  }

  getAllFlights() {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/allFlights");
  }
  getFlight(flightId) {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/getFlight/" + flightId);
  }
  addFlght(flight) {
    return axios.post(FLIGHT_SEARCH_REST_API_URL + "/addFlight", flight);
  }
  updateFlight(flight) {
    return axios.put(FLIGHT_SEARCH_REST_API_URL + "/updateFlight", flight);
  }
  deleteFlight(flightId) {
    return axios.delete(
      FLIGHT_SEARCH_REST_API_URL + "/deleteFlight/" + flightId
    );
  }
  //Airline
  getAllAirlines() {
    return axios.get(FLIGHT_SEARCH_AIRLINE_REST_API_URL + "/allAirlines");
  }
  getAirline(airlineId) {
    return axios.get(
      FLIGHT_SEARCH_AIRLINE_REST_API_URL + "/getAirline/" + airlineId
    );
  }
  addAirline(airline) {
    return axios.post(
      FLIGHT_SEARCH_AIRLINE_REST_API_URL + "/addAirline",
      airline
    );
  }
  updateAirline(airline) {
    return axios.put(
      FLIGHT_SEARCH_AIRLINE_REST_API_URL + "/updateAirline",
      airline
    );
  }
  deleteAirline(airlineId) {
    return axios.delete(
      FLIGHT_SEARCH_AIRLINE_REST_API_URL + "/deleteAirline/" + airlineId
    );
  }
  //Airport
  getAllAirports() {
    return axios.get(FLIGHT_SEARCH_AIRPORT_REST_API_URL + "/allAirports");
  }
  getAirport(airportId) {
    return axios.get(
      FLIGHT_SEARCH_AIRPORT_REST_API_URL + "/getAirport/" + airportId
    );
  }
  addAirport(airport) {
    return axios.post(
      FLIGHT_SEARCH_AIRPORT_REST_API_URL + "/addAirport",
      airport
    );
  }
  updateAirport(airport) {
    return axios.put(
      FLIGHT_SEARCH_AIRPORT_REST_API_URL + "/updateAirport",
      airport
    );
  }
  deleteAirport(airportId) {
    return axios.delete(
      FLIGHT_SEARCH_AIRPORT_REST_API_URL + "/deleteAirport/" + airportId
    );
  }

  //Flight Fare Microservice
  getAllFares() {
    return axios.get(FLIGHT_FARE_REST_API_URL + "/allFares");
  }
  getFare(flightId) {
    return axios.get(FLIGHT_FARE_REST_API_URL + "/getFare/" + flightId);
  }
  addFare(fare) {
    return axios.post(FLIGHT_FARE_REST_API_URL + "/addFare", fare);
  }
  updateFare(fare) {
    return axios.put(FLIGHT_FARE_REST_API_URL + "/updateFare", fare);
  }
  deleteFare(id) {
    return axios.delete(FLIGHT_FARE_REST_API_URL + "/deleteFare/" + id);
  }

  //Flight Book Microservice
  getAllBookings() {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/allBookings");
  }
  getBooking(bookingId) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/getBooking/" + bookingId);
  }
  updateBooking(booking) {
    return axios.put(FLIGHT_BOOK_REST_API_URL + "/updateBooking", booking);
  }
  cancelBooking(booking) {
    return axios.put(FLIGHT_BOOK_REST_API_URL + "/updateBooking", booking);
  }
  deleteBooking(bookingId) {
    return axios.delete(
      FLIGHT_BOOK_REST_API_URL + "/deleteBooking/" + bookingId
    );
  }
  getSelectedFlight(flightId) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/getFlight/" + flightId);
  }
  bookFlight(booking) {
    return axios.post(FLIGHT_BOOK_REST_API_URL + "/addBooking", booking);
  }

  getBookingsByUserId(userId) {
    return axios.get(
      FLIGHT_BOOK_REST_API_URL + "/getBookingsByUserId/" + userId
    );
  }
}

export default new FlightSearchService();
