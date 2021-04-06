import React, { Component } from "react";
import { Redirect } from "react-router";
import FlightService from "../../services/FlightService";

class FlightCheckInComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      prevId: this.props.match.params.id,
      booking: {
        id: "",
      },
    };
  }

  componentDidMount() {
    FlightService.getBooking(this.state.prevId).then((response) => {
      this.setState({ booking: response.data });
      console.log(this.state.booking);
    });
  }

  checkIn() {}

  render() {
    if (this.state.booking === {}) {
      return <Redirect to="/flights" />;
    } else {
      return (
        <div>
          <br></br>
          <h1 className="text-center"> Flights Check-In</h1>
          <br></br>
          <p className="text-center">{this.state.booking.id} is BOOKED</p>
        </div>
      );
    }
  }
}

export default FlightCheckInComponent;
