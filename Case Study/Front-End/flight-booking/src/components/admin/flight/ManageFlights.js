import React, { Component } from "react";
import { withRouter } from "react-router";
import FlightService from "../../../services/FlightService";

class ManageFlights extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flights: [],
    };
    this.addFlight = this.addFlight.bind(this);

    this.deleteFlight = this.deleteFlight.bind(this);
  }

  componentDidMount() {
    FlightService.getAllFlights().then((response) => {
      this.setState({ flights: response.data });
    });
  }

  addFlight() {
    this.props.history.push("/addFlight/add");
  }

  updateFlight(id) {
    this.props.history.push(`/updateFlight/${id}`);
  }

  deleteFlight(id) {
    FlightService.deleteFlight(id).then((res) => {
      this.setState({
        flights: this.state.flights.filter((flight) => flight.id !== id),
      });
    });
  }

  render() {
    return (
      <div>
        <h1 className="text-center"> Flights List</h1>
        <br></br>
        <div className="text-center">
          <button className="btn btn-primary" onClick={this.addFlight}>
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
              {this.state.flights.map((flight) => (
                <tr key={flight.id}>
                  <td> {flight.id}</td>
                  <td> {flight.airline.airlineName}</td>
                  <td> {flight.departureAirport.airportCode}</td>
                  <td> {flight.destinationAirport.airportCode}</td>
                  <td> {flight.departureDate}</td>
                  <td> {flight.arrivalDate}</td>
                  <td> {flight.departureTime}</td>
                  <td> {flight.arrivalTime}</td>
                  <td> {flight.seats}</td>
                  <td>
                    <button
                      onClick={() => this.updateFlight(flight.id)}
                      className="btn btn-info"
                    >
                      Edit
                    </button>
                  </td>

                  <td>
                    <button
                      onClick={() => this.deleteFlight(flight.id)}
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
}

export default withRouter(ManageFlights);
