import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function ManageFlight() {
  const history = useHistory();
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    let unmounted = false;
    FlightService.getAllFlights()
      .then((response) => {
        if (response.data !== null) {
          if (!unmounted) {
            setFlights(response.data);
          }
        }
      })
      .catch((error) => console.error(`Error :  ${error}`));
    return () => {
      unmounted = true;
    };
  }, [flights]);

  const addFlight = () => {
    history.push("/add_flight/add");
  };

  const updateFlight = (id) => {
    history.push(`/update_flight/${id}`);
  };

  const deleteFlight = (flightId) => {
    FlightService.deleteFlight(flightId)
      .then((res) => {
        setFlights(flights.filter((flight) => flight.flightId !== flightId));
      })
      .catch((error) => console.error(`Error :  ${error}`));
  };

  return (
    <div>
      <h1 className="text-center"> Flights List</h1>
      <br></br>
      <div className="text-center">
        <button className="btn btn-primary" onClick={addFlight}>
          {" "}
          Add Flight
        </button>
      </div>
      <br></br>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <td> Flight Id</td>
              <td> Flight Name</td>
              <td> Departure Airport</td>
              <td> Destination Airport</td>
              <td> Departure Date</td>
              <td> Arrival Date</td>
              <td> Departure Time</td>
              <td> Arrival Time</td>
              <td> Seats</td>
              <td> Edit</td>
              <td> Delete</td>
            </tr>
          </thead>
          <tbody>
            {flights.map((flight) => (
              <tr key={flight.id}>
                <td> {flight.id}</td>
                <td>
                  {" "}
                  {flight.airline === null ? "" : flight.airline.airlineName}
                </td>
                <td>
                  {" "}
                  {flight.departureAirport === null
                    ? ""
                    : flight.departureAirport.airportCode}
                </td>
                <td>
                  {" "}
                  {flight.destinationAirport === null
                    ? ""
                    : flight.destinationAirport.airportCode}
                </td>
                <td> {flight.departureDate}</td>
                <td> {flight.arrivalDate}</td>
                <td> {flight.departureTime}</td>
                <td> {flight.arrivalTime}</td>
                <td> {flight.seats}</td>
                <td>
                  <button
                    onClick={() => updateFlight(flight.id)}
                    className="btn btn-info"
                  >
                    Update
                  </button>
                </td>

                <td>
                  <button
                    onClick={() => deleteFlight(flight.id)}
                    className="btn btn-info"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ManageFlight;
