import React, { Component } from "react";
import { withRouter } from "react-router";
import FlightSearchComponent from "../user/FlightSearchComponent";

class HomeComponent extends Component {
  render() {
    return (
      <div>
        <FlightSearchComponent />
      </div>
    );
  }
}

export default withRouter(HomeComponent);
