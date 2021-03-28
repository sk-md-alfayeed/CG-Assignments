import "./App.css";
import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import DashboardComponent from "./components/admin/DashboardComponent";
import ManageFlightsComponent from "./components/admin/ManageFlightsComponent";
import AddOrUpdateFlightComponent from "./components/admin/AddOrUpdateFlightComponent";
import ManageFairsComponent from "./components/admin/ManageFairsComponent";
import AddOrUpdateFairComponent from "./components/admin/AddOrUpdateFairComponent";
import FlightAllComponent from "./components/user/FlightAllComponent";
import FlightSearchComponent from "./components/user/FlightSearchComponent";
import FlightBookComponent from "./components/user/FlightBookComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={DashboardComponent}></Route>

            <Route path="/dashboard" component={DashboardComponent}></Route>

            <Route
              path="/manageFlights"
              component={ManageFlightsComponent}
            ></Route>
            <Route
              path="/addFlight/:id"
              component={AddOrUpdateFlightComponent}
            ></Route>
            <Route
              path="/editFlight/:id"
              component={AddOrUpdateFlightComponent}
            ></Route>

            <Route path="/manageFairs" component={ManageFairsComponent}></Route>
            <Route
              path="/addFair/:id"
              component={AddOrUpdateFairComponent}
            ></Route>
            <Route
              path="/editFair/:id"
              component={AddOrUpdateFairComponent}
            ></Route>

            <Route path="/allFlights" component={FlightAllComponent}></Route>
            <Route path="/flights" component={FlightSearchComponent}></Route>
            <Route path="/booking/:id" component={FlightBookComponent}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
