import React from "react";
import { Link, withRouter } from "react-router-dom";

function Header() {
  //   let isLoggedIn = true;
  //   const token = localStorage.getItem("token");

  //   if (token === null) {
  //     isLoggedIn = false;
  //   }

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("role");
  };

  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <div className="container">
            <Link className="navbar-brand" to={"/home"}>
              <h2>Alpha Flights</h2>
            </Link>
            <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
              {localStorage.getItem("token") &&
              localStorage.getItem("role") === "USER" ? (
                <ul className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <Link className="nav-link" to={"/user_profile"}>
                      Profile
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to={"/user_booking"}>
                      Bookings
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link onClick={logout} className="nav-link" to={"/home"}>
                      Logout
                    </Link>
                  </li>
                </ul>
              ) : null}
              {localStorage.getItem("token") &&
              localStorage.getItem("role") === "ADMIN" ? (
                <ul className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <Link className="nav-link" to={"/manage_flight"}>
                      Manage Flights
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to={"/manage_fare"}>
                      Manage Fares
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to={"/manage_booking"}>
                      Manage Bookings
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link onClick={logout} className="nav-link" to={"/home"}>
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

export default withRouter(Header);
