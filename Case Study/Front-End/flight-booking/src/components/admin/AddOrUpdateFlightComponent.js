import React, { Component } from "react";
import FlightService from "../../services/FlightService";

class AddOrUpdateFlightComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      prevId: this.props.match.params.id,
      id: "",
      flightName: "",
      departureAirport: "",
      destinationAirport: "",
      departureDate: "",
      arrivalDate: "",
      departureTime: "",
      arrivalTime: "",
    };

    // this.changeFlightIdHandler = this.changeFlightIdHandler.bind(this);
    // this.changeFlightNameHandler = this.changeFlightNameHandler.bind(this);
    // this.changeDepartureAirportHandler = this.changeDepartureAirportHandler.bind(
    //   this
    // );
    // this.changeDestinationAirportHandler = this.changeDestinationAirportHandler.bind(
    //   this
    // );
    // this.changeDepartureDateHandler = this.changeDepartureDateHandler.bind(
    //   this
    // );
    // this.changeArrivalDateHandler = this.changeArrivalDateHandler.bind(this);
    // this.changeDepartureTimeHandler = this.changeDepartureTimeHandler.bind(
    //   this
    // );
    // this.changeArrivalTimeHandler = this.changeArrivalTimeHandler.bind(this);
  }

  componentDidMount() {
    if (this.state.id === "add") {
      return;
    } else {
      FlightService.findFlight(this.state.prevId).then((response) => {
        let flight = response.data;
        this.setState({
          id: flight.id,
          flightName: flight.flightName,
          departureAirport: flight.departureAirport,
          destinationAirport: flight.destinationAirport,
          departureDate: flight.departureDate,
          arrivalDate: flight.arrivalDate,
          departureTime: flight.departureTime,
          arrivalTime: flight.arrivalTime,
        });
      });
    }
  }

  //Value Change Events
  changeFlightIdHandler = (event) => {
    this.setState({ id: event.target.value });
  };
  changeFlightNameHandler = (event) => {
    this.setState({ flightName: event.target.value });
  };
  changeDepartureAirportHandler = (event) => {
    this.setState({ departureAirport: event.target.value });
  };
  changeDestinationAirportHandler = (event) => {
    this.setState({ destinationAirport: event.target.value });
  };
  changeDepartureDateHandler = (event) => {
    this.setState({ departureDate: event.target.value });
  };
  changeArrivalDateHandler = (event) => {
    this.setState({ arrivalDate: event.target.value });
  };
  changeDepartureTimeHandler = (event) => {
    this.setState({ departureTime: event.target.value });
  };
  changeArrivalTimeHandler = (event) => {
    this.setState({ arrivalTime: event.target.value });
  };

  //Update Flight

  saveOrUpdateFlight = (e) => {
    e.preventDefault();
    let flight = {
      id: this.state.id,
      flightName: this.state.flightName,
      departureAirport: this.state.departureAirport,
      destinationAirport: this.state.destinationAirport,
      departureDate: this.state.departureDate,
      arrivalDate: this.state.arrivalDate,
      departureTime: this.state.departureTime,
      arrivalTime: this.state.arrivalTime,
    };
    if (this.state.prevId === "add") {
      FlightService.addFlght(flight).then((res) => {
        this.props.history.push("/manageFlights");
      });
    } else {
      FlightService.updateFlight(flight).then((res) => {
        this.props.history.push("/manageFlights");
      });
    }
  };

  cancel() {
    this.props.history.push("/manageFlights");
  }
  getTitle() {
    if (this.state.prevId === "add") {
      return <h3 className="text-center">Add Flight</h3>;
    } else {
      return <h3 className="text-center">Update Flight</h3>;
    }
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              {this.getTitle()}
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> Flight Id: </label>
                    <input
                      placeholder="Flight Id"
                      name="id"
                      className="form-control"
                      value={this.state.id}
                      onChange={this.changeFlightIdHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Flight Name: </label>
                    <input
                      placeholder="Flight Name"
                      name="flightName"
                      className="form-control"
                      value={this.state.flightName}
                      onChange={this.changeFlightNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Departure Airport: </label>
                    <input
                      placeholder="Departure Airport"
                      name="departureAirport"
                      className="form-control"
                      value={this.state.departureAirport}
                      onChange={this.changeDepartureAirportHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Destination Airport: </label>
                    <input
                      placeholder="Destination Airport"
                      name="destinationAirport"
                      className="form-control"
                      value={this.state.destinationAirport}
                      onChange={this.changeDestinationAirportHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Departure Date: </label>
                    <input
                      //   type="date"
                      placeholder="Departure Date"
                      name="departureDate"
                      className="form-control"
                      value={this.state.departureDate}
                      onChange={this.changeDepartureDateHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Arrival Date: </label>
                    <input
                      //   type="date"
                      placeholder="Arrival Date"
                      name="arrivalDate"
                      className="form-control"
                      value={this.state.arrivalDate}
                      onChange={this.changeArrivalDateHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Departure Time: </label>
                    <input
                      placeholder="Departure Time"
                      name="departureTime"
                      className="form-control"
                      value={this.state.departureTime}
                      onChange={this.changeDepartureTimeHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Arrival Time: </label>
                    <input
                      placeholder="Arrival Time"
                      name="arrivalTime"
                      className="form-control"
                      value={this.state.arrivalTime}
                      onChange={this.changeArrivalTimeHandler}
                    />
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.saveOrUpdateFlight}
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

export default AddOrUpdateFlightComponent;
