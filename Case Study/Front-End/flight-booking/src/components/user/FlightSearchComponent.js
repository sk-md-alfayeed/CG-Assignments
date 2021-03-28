// import "../../style.css";
import React from "react";
import FlightService from "../../services/FlightService";

class FlightSearchComponent extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      flights: [],
      departureAirport: "",
      destinationAirport: "",
    };
    this.changeDepartureAirportHandler = this.changeDepartureAirportHandler.bind(
      this
    );
    this.changeDestinationAirportHandler = this.changeDestinationAirportHandler.bind(
      this
    );

    this.searchFlights = this.searchFlights.bind(this);
  }

  componentDidMount() {
    let search = {
      departureAirport: this.state.departureAirport,
      destinationAirport: this.state.destinationAirport,
    };
    FlightService.getFlights(search).then((response) => {
      this.setState({ flights: response.data });
    });
  }

  searchFlights = (event) => {
    event.preventDefault();
    let search = {
      departureAirport: this.state.departureAirport,
      destinationAirport: this.state.destinationAirport,
    };
    FlightService.getFlights(search).then((response) => {
      this.setState({ flights: response.data });
      this.props.history.push("/flights");
    });
  };

  changeDepartureAirportHandler = (event) => {
    this.setState({ departureAirport: event.target.value });
  };

  changeDestinationAirportHandler = (event) => {
    this.setState({ destinationAirport: event.target.value });
  };

  selectFlight(id) {
    this.props.history.push(`/booking/${id}`);
  }
  render() {
    return (
      <div>
        <br></br>
        <h1 className="text-center"> Flights Search</h1>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Departure: </label>
                    <select
                      className="form-control"
                      onChange={this.changeDepartureAirportHandler}
                    >
                      <option value="-">-</option>
                      <option value="DEL">DEL</option>
                      <option value="BOM">BOM</option>
                      <option value="CCU">CCU</option>
                    </select>
                  </div>
                  <br />
                  <div>
                    <label>Destination: </label>
                    <select
                      className="form-control"
                      onChange={this.changeDestinationAirportHandler}
                    >
                      <option value="-">-</option>
                      <option value="DEL">DEL</option>
                      <option value="BOM">BOM</option>
                      <option value="CCU">CCU</option>
                    </select>
                  </div>
                  <br />
                  <div className="text-center">
                    <button
                      className="btn btn-info"
                      onClick={this.searchFlights}
                    >
                      Search
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <br></br>
        <div>
          <h1 className="text-center"> Flights List</h1>
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
                  <td> Select</td>
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
                    <td>
                      <button
                        onClick={() => this.selectFlight(flight.id)}
                        className="btn btn-info"
                      >
                        Select
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}
export default FlightSearchComponent;
