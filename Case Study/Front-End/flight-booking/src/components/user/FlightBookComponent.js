import React, { Component } from "react";
import { Redirect } from "react-router";
import FlightService from "../../services/FlightService";

class FlightBookComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      prevId: this.props.match.params.id,
      booking: {},
      flight: {},
      airline: {},
      departureAirport: {},
      destinationAirport: {},
      passenger: {},
      id: "1",
      firstName: "",
      middleName: "",
      lastName: "",
      age: "",
      gender: "",

      username: "",
      bookingList: [],
    };
  }

  componentDidMount() {
    let username = localStorage.getItem("username");
    FlightService.getSelectedFlight(this.state.prevId).then((response) => {
      if (response.data) {
        this.setState({
          flight: response.data,
          airline: response.data.airline,
          departureAirport: response.data.departureAirport,
          destinationAirport: response.data.destinationAirport,
          username: username,
        });
      }
      console.log(this.state.flight);
    });

    FlightService.getUserBooking(username).then((response) => {
      if (response.data !== null) {
        console.log(response.data);
        this.setState({
          bookingList: response.data.bookingList,
        });
      }
    });
  }

  bookFlight = (event) => {
    event.preventDefault();
    let passenger = {
      id: this.state.id,
      firstName: this.state.firstName,
      middleName: this.state.middleName,
      lastName: this.state.lastName,
      age: this.state.age,
      gender: this.state.gender,
    };
    let myPassengerList = [];
    myPassengerList.push(passenger);

    let booking = {
      id: this.state.flight.id + "-" + this.state.airline.airlineName,
      flight: this.state.flight,
      passengerList: myPassengerList,
      active: true,
    };
    FlightService.bookFlight(booking).then((response) => {});

    let myBookingList = [];

    let myUserInformation = {};

    if (this.state.bookingList !== null) {
      let myBookingList = this.state.bookingList;
      myBookingList.push(booking);
      console.log(myBookingList);
      let userInformation = {
        username: this.state.username,
        bookingList: myBookingList,
      };
      myUserInformation = userInformation;
    } else {
      myBookingList.push(booking);
      console.log("else" + booking);
      let userInformation = {
        username: this.state.username,
        bookingList: myBookingList,
      };
      myUserInformation = userInformation;
    }

    console.log(myUserInformation);

    FlightService.addUserBooking(myUserInformation).then((response) => {
      this.props.history.push(
        `/checkIn/${
          this.state.flight.id + "-" + this.state.airline.airlineName
        }`
      );
    });
  };

  changeFirstNameHandler = (event) => {
    this.setState({ firstName: event.target.value });
  };
  changeMiddleNameHandler = (event) => {
    this.setState({ middleName: event.target.value });
  };
  changeLastNameHandler = (event) => {
    this.setState({ lastName: event.target.value });
  };
  changeAgeHandler = (event) => {
    this.setState({ age: event.target.value });
  };
  changeGenderHandler = (event) => {
    this.setState({ gender: event.target.value });
  };

  render() {
    if (this.state.flight === {}) {
      return <Redirect to="/flights" />;
    } else {
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
                  <td> {this.state.airline.airlineName}</td>
                  <td> {this.state.departureAirport.airportCode}</td>
                  <td> {this.state.destinationAirport.airportCode}</td>
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
                      <label> Passenger Id: </label>
                      <input
                        className="form-control"
                        placeholder="Passenger Id"
                        name="passengerId"
                        value={this.state.id}
                        disabled="disabled"
                      />
                    </div>
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
                        <option
                          placeholder="Prefer not to say"
                          value={this.state.gender}
                        >
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
}

export default FlightBookComponent;
