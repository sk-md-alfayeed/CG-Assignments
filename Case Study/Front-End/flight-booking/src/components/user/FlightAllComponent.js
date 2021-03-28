import React, { Component } from "react";
import FlightService from "../../services/FlightService";

class FlightAllComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flights: [],
    };
  }

  componentDidMount() {
    FlightService.getAllFlights().then((response) => {
      this.setState({ flights: response.data });
    });
  }

  render() {
    return (
      <div>
        <h1 className="text-center"> Flights List</h1>
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
              </tr>
            </thead>
            <tbody>
              {this.state.flights.map((flight) => (
                <tr key={flight.id}>
                  <td> {flight.id}</td>
                  <td> {flight.flightName}</td>
                  <td> {flight.departureAirport}</td>
                  <td> {flight.destinationAirport}</td>
                  <td> {flight.departureDate}</td>
                  <td> {flight.arrivalDate}</td>
                  <td> {flight.departureTime}</td>
                  <td> {flight.arrivalTime}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default FlightAllComponent;
