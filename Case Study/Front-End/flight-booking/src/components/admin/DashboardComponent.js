import React, { Component } from "react";

class DashboardComponent extends Component {
  constructor(props) {
    super(props);

    this.manageFlights = this.manageFlights.bind(this);
    this.manageFairs = this.manageFairs.bind(this);
  }
  manageFlights() {
    this.props.history.push("/manageFlights");
  }
  manageFairs() {
    this.props.history.push("/manageFairs");
  }
  render() {
    return (
      <div>
        <br></br>
        <h1 className="text-center">Admin Dashboard</h1>
        <br></br>
        <div class="text-center">
          <button className="btn btn-info m-1" onClick={this.manageFlights}>
            Manage Flights
          </button>
          <button className="btn btn-info m-1" onClick={this.manageFairs}>
            Manage Fairs
          </button>
          <button className="btn btn-info m-1">Manage Bookings</button>
        </div>
      </div>
    );
  }
}

export default DashboardComponent;
