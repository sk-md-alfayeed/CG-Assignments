import React, { Component } from "react";
import { withRouter } from "react-router";
import FlightService from "../../../services/FlightService";

class UpdateBookingComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      prevId: this.props.match.params.id,
      booking: {},
      flight: {},
      passengerList: [],

      newFlightId: "",

      id: "",
      firstName: "",
      middleName: "",
      lastName: "",
      age: "",
      gender: "",
    };
  }

  componentDidMount() {
    FlightService.getBooking(this.state.prevId).then((response) => {
      let [passenger1] = response.data.passengerList;
      this.setState({
        booking: response.data,
        flight: response.data.flight,
        passengerList: response.data.passengerList,

        id: passenger1.id,
        firstName: passenger1.firstName,
        middleName: passenger1.middleName,
        lastName: passenger1.lastName,
        age: passenger1.age,
        gender: passenger1.gender,
      });
    });
  }

  //Value Change Events

  changeFlightIdHandler = (event) => {
    this.setState({ newFlightId: event.target.value });
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

  //Update Flight

  updateBooking = (event) => {
    event.preventDefault();
    FlightService.getFlight(this.state.newFlightId).then((response) => {
      this.setState({
        flight: response.data,
      });
    });
    //Creating a Passenger Object
    let passenger = {
      id: this.state.id,
      firstName: this.state.firstName,
      middleName: this.state.middleName,
      lastName: this.state.lastName,
      age: this.state.age,
      gender: this.state.gender,
    };
    //Creating a PassengerList with Passengers
    let myPassengerList = [];
    myPassengerList.push(passenger);

    let booking = {
      id: this.state.flight.id + "-" + this.state.flight.airline.airlineName,
      flight: this.state.flight,
      passengerList: myPassengerList,
      active: true,
    };

    FlightService.updateBooking(booking).then((res) => {
      this.props.history.push("/manageBookings");
    });
  };

  cancel() {
    this.props.history.push("/manageBookings");
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-12 text-center">
              <br></br>
              Update Booking Details
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> Booking Id: </label>
                    <input
                      placeholder="Booking Id"
                      name="id"
                      className="form-control"
                      defaultValue={this.state.booking.id}
                      disabled="disabled"
                    />
                  </div>
                  <div className="form-group">
                    <label> Flight Id: </label>
                    <input
                      placeholder="Flight Id"
                      name="flightId"
                      className="form-control"
                      defaultValue={this.state.flight.id}
                      onChange={this.changeFlightIdHandler}
                    />
                  </div>
                  <div>
                    <table className="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <td> Passenger Id </td>
                          <td> First Name</td>
                          <td> Middle Name </td>
                          <td> First Name</td>
                          <td> Age</td>
                          <td> Gender</td>
                        </tr>
                      </thead>
                      <tbody>
                        {this.state.passengerList.map((passenger) => (
                          <tr key={passenger.id}>
                            <td>
                              <input
                                placeholder="Passenger Id"
                                name="id"
                                className="form-control"
                                defaultValue={passenger.id}
                                disabled="disabled"
                              />
                            </td>
                            <td>
                              <input
                                placeholder="First Name"
                                name="firstName"
                                className="form-control"
                                defaultValue={passenger.firstName}
                                onChange={this.changeFirstNameHandler}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Middle Name"
                                name="middleName"
                                className="form-control"
                                defaultValue={passenger.middleName}
                                onChange={this.changeMiddleNameHandler}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Last Name"
                                name="lastName"
                                className="form-control"
                                defaultValue={passenger.lastName}
                                onChange={this.changeLastNameHandler}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Age"
                                name="age"
                                className="form-control"
                                defaultValue={passenger.age}
                                onChange={this.changeAgeHandler}
                              />
                            </td>
                            <td>
                              <select
                                className="form-control"
                                name="gender"
                                defaultValue={passenger.gender}
                                onChange={this.changeGenderHandler}
                              >
                                <option
                                  placeholder="Prefer not to say"
                                  defaultValue={passenger.gender}
                                >
                                  -
                                </option>
                                <option defaultValue="Female">Female</option>
                                <option defaultValue="Male">Male</option>
                                <option defaultValue="Transgender">
                                  Transgender
                                </option>
                              </select>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.updateBooking}
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
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

export default withRouter(UpdateBookingComponent);
