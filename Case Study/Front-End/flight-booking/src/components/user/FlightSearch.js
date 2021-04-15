import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import FlightService from "../../services/FlightService";
import { Button, Table } from "react-bootstrap";

function FlightSearch() {
  const history = useHistory();
  const [flights, setFlights] = useState([]);
  const [airportList, setAirportList] = useState([]);
  const [departureAirportCode, setDepartureAirportCode] = useState("");
  const [destinationAirportCode, setDestinationAirportCode] = useState("");

  useEffect(() => {
    //Getting Airports list
    FlightService.getAllAirports()
      .then((response) => {
        setAirportList(response.data);
        setAirportList(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, []);

  const searchFlights = (event) => {
    event.preventDefault();
    let search = {
      departureAirport: departureAirportCode,
      destinationAirport: destinationAirportCode,
    };
    FlightService.getFlights(search)
      .then((response) => {
        setFlights(response.data);
      })
      .catch((error) => {
        console.error(`Error :  ${error} : No Flights Available"`);
        setFlights([]);
      });
  };

  const selectFlight = (id) => {
    history.push(`/booking/${id}`);
  };

  return (
    <div>
      <div className="container">
        <div className="row mt-5 pt-5">
          <div className="col-lg-4 mb-5 grid-margin">
            <div className="card h-100">
              <h4 className="card-header">Search Flights</h4>
              <div className="card-body">
                <form>
                  <br></br>
                  <div className="form-group">
                    <label> Departure Airport: </label>
                    <select
                      className="form-control"
                      name="departureAirport"
                      value={departureAirportCode || ""}
                      onChange={(e) => {
                        setDepartureAirportCode(e.target.value);
                      }}
                    >
                      <option value="">-</option>
                      {airportList.map((airport) => (
                        <option
                          key={airport.airportCode}
                          value={airport.airportCode}
                        >
                          {airport.airportCode}
                        </option>
                      ))}
                    </select>
                  </div>
                  <br></br>
                  <div className="form-group">
                    <label> Destination Airport: </label>
                    <select
                      className="form-control"
                      name="destinatonAirport"
                      value={destinationAirportCode || ""}
                      onChange={(e) => {
                        setDestinationAirportCode(e.target.value);
                      }}
                    >
                      <option value="">-</option>
                      {airportList.map((airport) => (
                        <option
                          key={airport.airportCode}
                          value={airport.airportCode}
                        >
                          {airport.airportCode}
                        </option>
                      ))}
                    </select>
                  </div>
                  <br></br>
                  <br></br>
                  <div className="text-center">
                    <Button className="btn btn-info" onClick={searchFlights}>
                      Search
                    </Button>
                  </div>
                  <br></br>
                </form>
              </div>
            </div>
          </div>
          {flights.length !== 0 ? (
            <div className="col-lg-8 mb-5 grid-margin">
              <div className="card h-100">
                <h4 className="card-header">
                  Available Flights {departureAirportCode}{" "}
                  {destinationAirportCode}
                </h4>
                <div className="card-body">
                  <Table
                    striped
                    bordered
                    hover
                    style={{
                      height: "300px",
                      overflow: "scroll",
                      display: "block",
                    }}
                  >
                    <thead>
                      <tr>
                        <td> Flight Id</td>
                        <td> Flight Name</td>
                        {/* <td> Departure Airport</td>
                      <td> Destination Airport</td> */}
                        <td> Departure Date</td>
                        <td> Arrival Date</td>
                        <td> Departure Time</td>
                        <td> Arrival Time</td>
                        <td> Select</td>
                      </tr>
                    </thead>
                    <tbody>
                      {flights.map((flight) => (
                        <tr key={flight.id}>
                          <td> {flight.id}</td>
                          <td> {flight.airline.airlineName}</td>
                          {/* <td> {flight.departureAirport.airportCode}</td>
                        <td> {flight.destinationAirport.airportCode}</td> */}
                          <td> {flight.departureDate}</td>
                          <td> {flight.arrivalDate}</td>
                          <td> {flight.departureTime}</td>
                          <td> {flight.arrivalTime}</td>
                          <td>
                            <button
                              onClick={() => selectFlight(flight.id)}
                              className="btn btn-info"
                            >
                              Select
                            </button>
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </Table>
                </div>
              </div>
            </div>
          ) : null}
        </div>
      </div>
    </div>
  );
}

export default FlightSearch;
