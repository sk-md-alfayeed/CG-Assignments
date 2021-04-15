import React, { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { useParams } from "react-router";
import FlightService from "../../services/FlightService";

function CheckIn() {
  const { id } = useParams();
  const [pnrNo, setPnrNo] = useState("");
  const [email, setEmail] = useState("");
  const [selectedSeat, setSelectedSeat] = useState("");
  const [flight, setFlight] = useState({});
  const [checkIn, setCheckIn] = useState({});
  const [passengerList, setPassengerList] = useState([]);

  useEffect(() => {
    if (id !== null) {
      let search = {
        pnrNo: pnrNo,
        email: email,
      };
      FlightService.getCheckIn(search)
        .then((response) => {
          setCheckIn(response.data);
          setPassengerList(response.data.passengerList);
        })
        .catch((error) => console.error(`Error :  ${error}`));
      FlightService.getFlight(checkIn.flightId)
        .then((response) => {
          setFlight(response.data);
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  }, [id, email, pnrNo, checkIn.flightId]);

  const searchPnr = (event) => {
    event.preventDefault();
    let search = {
      pnrNo: pnrNo,
      email: email,
    };
    FlightService.getCheckIn(search)
      .then((response) => {
        setCheckIn(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  };

  return (
    <div>
      <div className="container">
        <div className="row mt-5 pt-5 sm-8">
          <div className="col-md-6 offset-md-3 offset-md-3 grid-margin">
            <div className="card h-100">
              <h4 className="card-header">Acknowledgment</h4>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> PNR No : </label>
                    <input
                      className="form-control"
                      name="pnrNo"
                      value={pnrNo || ""}
                      onChange={(e) => {
                        setPnrNo(e.target.value);
                      }}
                    ></input>
                  </div>
                  <div className="form-group">
                    <label> Email : </label>
                    <input
                      className="form-control"
                      name="email"
                      value={email || ""}
                      onChange={(e) => {
                        setEmail(e.target.value);
                      }}
                    ></input>
                  </div>
                  <div className="text-center">
                    <Button className="btn btn-info" onClick={searchPnr}>
                      Search PNR
                    </Button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

      {true ? (
        <div className="container">
          <div className="row mt-5 pt-5 sm-8">
            <div className="col-md-6 offset-md-3 offset-md-3 grid-margin">
              <div className="card h-100">
                <h4 className="card-header">Acknowledgment</h4>
                <div className="card-body">
                  <Table striped bordered hover>
                    <thead>
                      <tr>
                        <td> Select</td>
                        <td> Passenger</td>
                        <td> Seat No</td>
                        <td> Boarding Pass</td>
                      </tr>
                    </thead>
                    <tbody>
                      {passengerList.map((passenger) => (
                        <tr key={passenger.id}>
                          <td> {passenger.id}</td>
                          <td>
                            {" "}
                            {passenger.firstName +
                              passenger.middleName +
                              passenger.lastName}
                          </td>
                          <td>
                            {" "}
                            {
                              <select
                                className="form-control"
                                name="availableSeats"
                                value={selectedSeat || ""}
                                onChange={(e) => {
                                  setSelectedSeat(e.target.value);
                                }}
                              >
                                <option value="">-</option>
                                {flight.availableSeats.map((seat) => (
                                  <option key={seat} value={seat}>
                                    {seat}
                                  </option>
                                ))}
                              </select>
                            }
                          </td>
                          <td> {checkIn.boardinPass}</td>
                        </tr>
                      ))}
                    </tbody>
                  </Table>
                </div>
              </div>
            </div>
          </div>
        </div>
      ) : null}
    </div>
  );
}

export default CheckIn;
