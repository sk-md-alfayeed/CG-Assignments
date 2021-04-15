import React, { useState, useEffect } from "react";
import { useParams, useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function AddOrUpdateFlight() {
  const history = useHistory();
  const { id } = useParams();

  const [airlineList, setAirlineList] = useState([]);
  const [airportList, setAirportList] = useState([]);

  const [flightId, setFlightId] = useState("");
  const [departureDate, setDepartureDate] = useState("");
  const [arrivalDate, setArrivalDate] = useState("");
  const [departureTime, setDepartureTime] = useState("");
  const [arrivalTime, setArrivalTime] = useState("");
  const [seats, setSeats] = useState("");

  const [airlineName, setAirlineName] = useState("");
  const [departureAirportCode, setDepartureAirportCode] = useState("");
  const [destinationAirportCode, setDestinationAirportCode] = useState("");

  useEffect(() => {
    FlightService.getAllAirlines()
      .then((response) => {
        setAirlineList(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
    FlightService.getAllAirports()
      .then((response) => {
        setAirportList(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
    if (id === "add") {
      setAirlineName("");
      setDepartureAirportCode("");
      setDestinationAirportCode("");
      return;
    } else {
      FlightService.getFlight(id)
        .then((response) => {
          let flight = response.data;
          setFlightId(flight.id);
          setDepartureDate(flight.departureDate);
          setArrivalDate(flight.arrivalDate);
          setDepartureTime(flight.departureTime);
          setArrivalTime(flight.arrivalTime);
          setSeats(flight.seats);

          setAirlineName(flight.airline.airlineName);
          setDepartureAirportCode(flight.departureAirport.airportCode);
          setDestinationAirportCode(flight.destinationAirport.airportCode);
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  }, [id]);

  const save = (event) => {
    event.preventDefault();
    let flight = {
      id: flightId,
      airline:
        airlineName !== ""
          ? airlineList.find((element) => element.airlineName === airlineName)
          : {},
      departureAirport:
        departureAirportCode !== ""
          ? airportList.find(
              (element) => element.airportCode === departureAirportCode
            )
          : {},
      destinationAirport:
        destinationAirportCode !== ""
          ? airportList.find(
              (element) => element.airportCode === destinationAirportCode
            )
          : {},
      departureDate: departureDate,
      arrivalDate: arrivalDate,
      departureTime: departureTime,
      arrivalTime: arrivalTime,
      seats: seats,
    };
    if (id === "add") {
      FlightService.addFlght(flight)
        .then((res) => {
          history.push("/manage_flight");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    } else {
      FlightService.updateFlight(flight)
        .then((res) => {
          history.push("/manage_flight");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  };

  const cancel = () => {
    history.push("/manage_flight");
  };

  const getTitle = () => {
    if (id === "add") {
      return <h3 className="text-center">Add Flight</h3>;
    } else {
      return <h3 className="text-center">Update Flight</h3>;
    }
  };

  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <br></br>
            {getTitle()}
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label> Flight Id: </label>
                  <input
                    placeholder="Flight Id"
                    name="flightId"
                    className="form-control"
                    value={flightId || ""}
                    onChange={(e) => {
                      setFlightId(e.target.value);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label> Flight Name: </label>
                  <select
                    className="form-control"
                    name="airlineName"
                    value={airlineName || ""}
                    onChange={(e) => {
                      setAirlineName(e.target.value);
                    }}
                  >
                    <option value="">-</option>
                    {airlineList.map((airline) => (
                      <option
                        key={airline.airlineName}
                        value={airline.airlineName}
                      >
                        {airline.airlineName}
                      </option>
                    ))}
                  </select>
                </div>
                <div className="form-group">
                  <label> Departure Airport: </label>
                  <select
                    className="form-control"
                    name="departureAirport"
                    value={departureAirportCode || ""}
                    onChange={(e) => {
                      setDepartureAirportCode(e.target.value);
                    }}
                  >
                    <option value="">-</option>
                    {airportList.map((airport) => (
                      <option
                        key={airport.airportCode}
                        value={airport.airportCode}
                      >
                        {airport.airportCode}
                      </option>
                    ))}
                  </select>
                </div>
                <div className="form-group">
                  <label> Destination Airport: </label>
                  <select
                    className="form-control"
                    name="destinatonAirport"
                    value={destinationAirportCode || ""}
                    onChange={(e) => {
                      setDestinationAirportCode(e.target.value);
                    }}
                  >
                    <option value="">-</option>
                    {airportList.map((airport) => (
                      <option
                        key={airport.airportCode}
                        value={airport.airportCode}
                      >
                        {airport.airportCode}
                      </option>
                    ))}
                  </select>
                </div>
                <div className="form-group">
                  <label> Departure Date: </label>
                  <input
                    //   type="date"
                    placeholder="Departure Date"
                    name="departureDate"
                    className="form-control"
                    value={departureDate || ""}
                    onChange={(e) => {
                      setDepartureDate(e.target.value);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label> Arrival Date: </label>
                  <input
                    //   type="date"
                    placeholder="Arrival Date"
                    name="arrivalDate"
                    className="form-control"
                    value={arrivalDate || ""}
                    onChange={(e) => {
                      setArrivalDate(e.target.value);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label> Departure Time: </label>
                  <input
                    placeholder="Departure Time"
                    name="departureTime"
                    className="form-control"
                    value={departureTime || ""}
                    onChange={(e) => {
                      setDepartureTime(e.target.value);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label> Arrival Time: </label>
                  <input
                    placeholder="Arrival Time"
                    name="arrivalTime"
                    className="form-control"
                    value={arrivalTime || ""}
                    onChange={(e) => {
                      setArrivalTime(e.target.value);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label> Seats: </label>
                  <input
                    placeholder="Seats"
                    name="seats"
                    className="form-control"
                    value={seats || ""}
                    onChange={(e) => {
                      setSeats(e.target.value);
                    }}
                  />
                </div>

                <button className="btn btn-success" onClick={save}>
                  Save
                </button>
                <button
                  className="btn btn-danger"
                  onClick={cancel}
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

export default AddOrUpdateFlight;
