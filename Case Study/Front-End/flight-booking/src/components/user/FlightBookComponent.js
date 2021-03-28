import React, { Component } from "react";
import FlightService from "../../services/FlightService";

class FlightBookComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      flight: {},
    };
  }

  componentDidMount() {
    FlightService.getFlight(this.state.id).then((response) => {
      this.setState({ flight: response.data });
      console.log(this.state.flight);
    });
  }

  render() {
    return (
      <div>
        <h2 className="text-center"> Flights Booking</h2>
        <br></br>
        <div>
          <h3 className="text-center"> Selected Flight</h3>
          <br></br>
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
                <td> Flight Fair</td>
              </tr>
            </thead>
            <tbody>
              <tr key={this.state.flight.id}>
                <td> {this.state.flight.id}</td>
                <td> {this.state.flight.flightName}</td>
                <td> {this.state.flight.departureAirport}</td>
                <td> {this.state.flight.destinationAirport}</td>
                <td> {this.state.flight.departureDate}</td>
                <td> {this.state.flight.arrivalDate}</td>
                <td> {this.state.flight.departureTime}</td>
                <td> {this.state.flight.arrivalTime}</td>
                <td> {this.state.flight.flightFair}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <br></br>
        <h3 className="text-center"> Passenger</h3>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> First Name: </label>
                    <input
                      className="form-control"
                      placeholder="First Name"
                      name="firstName"
                      value={this.state.firstName}
                      onChange={this.changeFirstNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Middle Name: </label>
                    <input
                      className="form-control"
                      placeholder="Middle Name"
                      name="middleName"
                      value={this.state.middleName}
                      onChange={this.changeMiddleNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Last Name: </label>
                    <input
                      className="form-control"
                      placeholder="Last Name"
                      name="lastName"
                      value={this.state.lastName}
                      onChange={this.changeLastNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Age: </label>
                    <input
                      className="form-control"
                      placeholder="Age"
                      name="Age"
                      value={this.state.age}
                      onChange={this.changeAgeHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Gender: </label>
                    <select
                      className="form-control"
                      onChange={this.changeGenderHandler}
                    >
                      <option placeholder="Prefer not to say" value="-">
                        -
                      </option>
                      <option value="Female">Female</option>
                      <option value="Male">Male</option>
                      <option value="Transgender">Transgender</option>
                    </select>
                  </div>
                  <button
                    className="btn btn-success"
                    id="submit"
                    onClick={this.bookFlight}
                  >
                    Book
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default FlightBookComponent;
