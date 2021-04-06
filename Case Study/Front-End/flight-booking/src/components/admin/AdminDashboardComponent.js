import React, { Component } from "react";
import { Link } from "react-router-dom";

class AdminDashboardComponent extends Component {
  render() {
    return (
      <div>
        <h1 className="text-center">Admin Dashboard</h1>
        <div>
          <Link className="nav-link text-center" to={"/AddOrUpdateAirline"}>
            Manage Airline
          </Link>
          <Link className="nav-link text-center" to={"/AddOrUpdateAirport"}>
            Manage Airport
          </Link>
        </div>
      </div>
    );
  }
}

export default AdminDashboardComponent;
