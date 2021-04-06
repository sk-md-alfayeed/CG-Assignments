import React, { Component } from "react";
import { withRouter } from "react-router";
import FlightService from "../../../services/FlightService";

class ManageBookingsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: [],
      flight: {},
      airline: {},
      departureAirport: {},
      destinationAirport: {},
    };

    // this.cancelBooking = this.cancelBooking.bind(this);
  }

  componentDidMount() {
    FlightService.getAllBookings().then((response) => {
      this.setState({
        bookings: response.data,
        flight: response.data.flight,
        airline: this.state.flight.airline,
        departureAirport: this.state.flight.departureAirport,
        destinationAirport: this.state.flight.destinationAirport,
      });
      console.log(this.state.flight);
    });
  }

  editBooking(id) {
    this.props.history.push(`/updateBooking/${id}`);
  }

  cancelBooking(booking) {
    booking.active = !booking.active;
    FlightService.cancelBooking(booking).then((res) => {
      this.setState({
        bookings: this.state.bookings,
      });
    });
  }

  render() {
    return (
      <div>
        <h1 className="text-center"> Bookings List</h1>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <td> Booking Id</td>
                <td> Flight</td>
                <td> Passenger List</td>
                <td> Active</td>
                <td> Update</td>
                <td> Change Status</td>
              </tr>
            </thead>
            <tbody>
              {this.state.bookings.map((booking) => (
                <tr key={booking.id}>
                  <td> {booking.id}</td>
                  <td>
                    {
                      <div className="row">
                        <table className="table table-striped table-bordered">
                          <thead>
                            <tr>
                              <td> Flight Id</td>
                              <td> Flight Name</td>
                              <td> Departure Airport</td>
                              <td> Destination Airport</td>
                              {/* <td> Departure Date</td>
                              <td> Arrival Date</td>
                              <td> Departure Time</td>
                              <td> Arrival Time</td> */}
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td> {booking.flight.id}</td>
                              <td> {booking.flight.airline.airlineName}</td>
                              <td>
                                {" "}
                                {booking.flight.departureAirport.airportCode}
                              </td>
                              <td>
                                {" "}
                                {booking.flight.destinationAirport.airportCode}
                              </td>
                              {/* <td> {booking.flight.departureDate}</td>
                              <td> {booking.flight.arrivalDate}</td>
                              <td> {booking.flight.departureTime}</td>
                              <td> {booking.flight.arrivalTime}</td> */}
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    }
                  </td>
                  <td>
                    {
                      <div>
                        <table className="table table-striped table-bordered">
                          <thead>
                            <tr>
                              <td> Passenger Id</td>
                              <td> First Name</td>
                              <td> Middle Name </td>
                              <td> First Name</td>
                              <td> Age</td>
                              <td> Gender</td>
                            </tr>
                          </thead>
                          <tbody>
                            {booking.passengerList.map((passenger) => (
                              <tr key={passenger.id}>
                                <td> {passenger.id}</td>
                                <td> {passenger.firstName}</td>
                                <td> {passenger.middleName}</td>
                                <td> {passenger.lastName}</td>
                                <td> {passenger.age}</td>
                                <td> {passenger.gender}</td>
                              </tr>
                            ))}
                          </tbody>
                        </table>
                      </div>
                    }
                  </td>

                  <td> {booking.active.toString()}</td>
                  <td>
                    <button
                      onClick={() => this.editBooking(booking.id)}
                      className="btn btn-info"
                    >
                      Edit
                    </button>
                  </td>

                  <td>
                    <button
                      onClick={() => this.cancelBooking(booking)}
                      className="btn btn-info"
                    >
                      Change
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

export default withRouter(ManageBookingsComponent);
