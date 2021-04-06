import "./App.css";
import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import FlightAllComponent from "./components/user/FlightAllComponent";
import FlightSearchComponent from "./components/user/FlightSearchComponent";
import FlightBookComponent from "./components/user/FlightBookComponent";
import FooterComponent from "./components/global/FooterComponent";
import HeaderComponent from "./components/global/HeaderComponent";
import FlightCheckInComponent from "./components/user/FlightCheckInComponent";

import HomeComponent from "./components/global/HomeComponent";
import LoginComponentClass from "./components/auth/LoginComponentClass";
import AdminDashboardComponent from "./components/admin/AdminDashboardComponent";
import UserDashboardComponent from "./components/user/UserDashboardComponent";
import RegisterComponent from "./components/auth/RegisterComponent";
import ProtectedRoute from "./components/global/ProtectedRoute";
import ManageFlightsComponent from "./components/admin/flight/ManageFlights";
import ManageFairsComponent from "./components/admin/fair/ManageFairsComponent";
import AddOrUpdateFairComponent from "./components/admin/fair/AddOrUpdateFairComponent";
import ManageBookingsComponent from "./components/admin/booking/ManageBookingsComponent";
import UpdateBookingComponent from "./components/admin/booking/UpdateBookingComponent";
import AddOrUpdateFlight from "./components/admin/flight/AddOrUpdateFlight";
import AddOrUpdateAirline from "./components/admin/airline/AddOrUpdateAirline";
import AddOrUpdateAirport from "./components/admin/airport/AddOrUpdateAirport";
import UserBooking from "./components/user/UserBooking";
import UserProfile from "./components/user/UserProfile";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <br></br>
        <div className="container">
          <Switch>
            <Route path="/" exact component={HomeComponent}></Route>
            <Route path="/home" component={HomeComponent}></Route>
            {/* <Route path="/login" component={LoginComponent}></Route> */}
            <Route path="/login" component={LoginComponentClass}></Route>
            <Route path="/register" component={RegisterComponent}></Route>
            {/* <Route path="/register" component={RegisterComponentClass}></Route> */}

            <Route path="/userProfile" component={UserProfile}></Route>
            <Route path="/userBooking" component={UserBooking}></Route>
            <Route
              path="/userDashboard"
              component={UserDashboardComponent}
            ></Route>

            <Route path="/allFlights" component={FlightAllComponent}></Route>
            <Route path="/flights" component={FlightSearchComponent}></Route>
            <Route path="/booking/:id" component={FlightBookComponent}></Route>
            <Route
              path="/checkIn/:id"
              component={FlightCheckInComponent}
            ></Route>

            <ProtectedRoute
              path="/adminDashboard"
              component={AdminDashboardComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/manageFlights"
              component={ManageFlightsComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/addFlight/:id"
              component={AddOrUpdateFlight}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/updateFlight/:id"
              component={AddOrUpdateFlight}
            ></ProtectedRoute>

            <ProtectedRoute
              path="/manageFairs"
              component={ManageFairsComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/addFair/:id"
              component={AddOrUpdateFairComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/updateFair/:id"
              component={AddOrUpdateFairComponent}
            ></ProtectedRoute>

            <ProtectedRoute
              path="/manageBookings"
              component={ManageBookingsComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/updateBooking/:id"
              component={UpdateBookingComponent}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/addOrUpdateAirline/:id"
              component={AddOrUpdateAirline}
            ></ProtectedRoute>
            <ProtectedRoute
              path="/addOrUpdateAirport/:id"
              component={AddOrUpdateAirport}
            ></ProtectedRoute>
          </Switch>
        </div>
        <br></br>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
