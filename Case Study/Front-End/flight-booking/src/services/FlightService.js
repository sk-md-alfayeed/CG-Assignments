import axios from "axios";

//Flight Search Microservice
const FLIGHT_SEARCH_REST_API_URL = "http://localhost:8081";

//Flight Fair Microservice
const FLIGHT_FAIR_REST_API_URL = "http://localhost:8082";

//Flight Book Microservice
const FLIGHT_BOOK_REST_API_URL = "http://localhost:8083";

class FlightSearchService {
  //Flight Search Microservice
  getAllFlights() {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/allFlights");
  }
  getFlights(search) {
    return axios.post(FLIGHT_SEARCH_REST_API_URL + "/flights", search);
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
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/allAirlines");
  }
  getAirline(airlineId) {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/getAirline/" + airlineId);
  }
  addAirline(airline) {
    return axios.post(FLIGHT_SEARCH_REST_API_URL + "/addAirline", airline);
  }
  updateAirline(airline) {
    return axios.put(FLIGHT_SEARCH_REST_API_URL + "/updateAirline", airline);
  }
  deleteAirline(airlineId) {
    return axios.delete(
      FLIGHT_SEARCH_REST_API_URL + "/deleteAirline/" + airlineId
    );
  }
  //Airport
  getAllAirports() {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/allAirports");
  }
  getAirport(airportId) {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/getAirport/" + airportId);
  }
  addAirport(airport) {
    return axios.post(FLIGHT_SEARCH_REST_API_URL + "/addAirport", airport);
  }
  updateAirport(airport) {
    return axios.put(FLIGHT_SEARCH_REST_API_URL + "/updateAirport", airport);
  }
  deleteAirport(airportId) {
    return axios.delete(
      FLIGHT_SEARCH_REST_API_URL + "/deleteAirport/" + airportId
    );
  }

  //Flight Fair Microservice
  getAllFairs() {
    return axios.get(FLIGHT_FAIR_REST_API_URL + "/allFairs");
  }
  getFair(flightId) {
    return axios.get(FLIGHT_FAIR_REST_API_URL + "/getFair/" + flightId);
  }
  addFair(fair) {
    return axios.post(FLIGHT_FAIR_REST_API_URL + "/addFair", fair);
  }
  updateFair(fair) {
    return axios.put(FLIGHT_FAIR_REST_API_URL + "/updateFair", fair);
  }
  deleteFair(flightId) {
    return axios.delete(FLIGHT_FAIR_REST_API_URL + "/deleteFair/" + flightId);
  }

  //Flight Book Microservice
  getAllBookings() {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/allBookings");
  }
  getBooking(bookingId) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/getBooking/" + bookingId);
  }
  updateBooking(booking) {
    return axios.put(FLIGHT_BOOK_REST_API_URL + "/updateBooking/", booking);
  }
  cancelBooking(booking) {
    return axios.put(FLIGHT_BOOK_REST_API_URL + "/updateBooking/", booking);
  }
  getSelectedFlight(flightId) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/getFlight/" + flightId);
  }
  bookFlight(booking) {
    return axios.post(FLIGHT_BOOK_REST_API_URL + "/addBooking", booking);
  }

  getUserBooking(username) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/getUserBooking/" + username);
  }
  addUserBooking(userInformation) {
    return axios.post(
      FLIGHT_BOOK_REST_API_URL + "/addUserBooking",
      userInformation
    );
  }
}

export default new FlightSearchService();
