import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    const token = localStorage.getItem("token");

    let isLoggedIn = true;
    if (token == null) {
      isLoggedIn = false;
    }
    this.state = {
      isLoggedIn,
    };
  }

  logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("role");
  };

  render() {
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container">
              <Link className="navbar-brand" to={"/home"}>
                <h2>Alpha Flights</h2>
              </Link>
              <div
                className="collapse navbar-collapse"
                id="navbarTogglerDemo02"
              >
                {localStorage.getItem("token") &&
                localStorage.getItem("role") === "USER" ? (
                  <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                      <Link className="nav-link" to={"/userProfile"}>
                        Profile
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to={"/userBooking"}>
                        Bookings
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link
                        onClick={this.logout}
                        className="nav-link"
                        to={"/home"}
                      >
                        Logout
                      </Link>
                    </li>
                  </ul>
                ) : null}
                {localStorage.getItem("token") &&
                localStorage.getItem("role") === "ADMIN" ? (
                  <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                      <Link className="nav-link" to={"/manageFlights"}>
                        Manage Flights
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to={"/manageFairs"}>
                        Manage Fairs
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to={"/manageBookings"}>
                        Manage Bookings
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link
                        onClick={this.logout}
                        className="nav-link"
                        to={"/home"}
                      >
                        Logout
                      </Link>
                    </li>
                  </ul>
                ) : null}
                {!localStorage.getItem("token") ? (
                  <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                      <Link className="nav-link" to={"/login"}>
                        Login
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to={"/register"}>
                        Sign up
                      </Link>
                    </li>
                  </ul>
                ) : null}
              </div>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default withRouter(HeaderComponent);
