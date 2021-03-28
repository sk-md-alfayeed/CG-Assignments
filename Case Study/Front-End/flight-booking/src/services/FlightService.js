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
  findFlight(flightId) {
    return axios.get(FLIGHT_SEARCH_REST_API_URL + "/findFlight/" + flightId);
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

  //Flight Fair Microservice
  getAllFairs() {
    return axios.get(FLIGHT_FAIR_REST_API_URL + "/allFairs");
  }
  getFair(flightId) {
    return axios.get(FLIGHT_FAIR_REST_API_URL + "/findFair/" + flightId);
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
  getFlight(flightId) {
    return axios.get(FLIGHT_BOOK_REST_API_URL + "/findFlight/" + flightId);
  }
}

export default new FlightSearchService();
