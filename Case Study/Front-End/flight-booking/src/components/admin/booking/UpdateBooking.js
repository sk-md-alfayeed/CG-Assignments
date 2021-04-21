import React, { useState, useEffect } from "react";
import { useHistory, useParams } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function UpdateBooking() {
  const { id } = useParams();

  const username = localStorage.getItem("username");

  const history = useHistory();
  const [booking, setBooking] = useState({});
  const [passengerList, setPassengerList] = useState([]);

  const [flight, setFlight] = useState({});

  const [passengerId, setPassengerId] = useState("");
  const [firstName, setFirstName] = useState("");
  const [middleName, setMiddleName] = useState("");
  const [lastName, setLastName] = useState("");
  const [age, setAge] = useState("");
  const [gender, setGender] = useState("");

  useEffect(() => {
    FlightService.getBooking(id)
      .then((response) => {
        setBooking(response.data);
        setFlight(response.data.flight);
        setPassengerList(response.data.passengerList);

        setPassengerId(response.data.passengerList[0].id);
        setFirstName(response.data.passengerList[0].firstName);
        setMiddleName(response.data.passengerList[0].middleName);
        setLastName(response.data.passengerList[0].lastName);
        setAge(response.data.passengerList[0].age);
        setGender(response.data.passengerList[0].gender);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, [id]);

  const updateBooking = (event) => {
    event.preventDefault();

    //Creating a Passenger Object
    let passenger = {
      id: passengerId,
      firstName: firstName,
      middleName: middleName,
      lastName: lastName,
      age: age,
      gender: gender,
    };

    //Creating a PassengerList with Passengers
    let myPassengerList = [];
    myPassengerList.push(passenger);

    let myBooking = {
      id: booking.id,
      pnrNo: booking.pnrNo,
      flight: flight,
      passengerList: myPassengerList,
      active: true,
      userId: booking.userId,
    };

    FlightService.updateBooking(myBooking).then((res) => {
      history.push("/manage_booking");
    });
  };

  const cancel = () => {
    history.push("/manage_booking");
  };

  return (
    <div>
      {username === booking.userId || username === "admin" ? (
        <div className="container">
          <div className="row">
            <div className="card col-md-12 text-center">
              <br></br>
              Update Booking Details
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> Booking Id: </label>
                    <input
                      placeholder="Booking Id"
                      name="id"
                      className="form-control"
                      value={booking.id || ""}
                      disabled="disabled"
                    />
                  </div>
                  <div className="form-group">
                    <label> Flight Id: </label>
                    <input
                      placeholder="Flight Id"
                      name="flightId"
                      className="form-control"
                      value={flight.id || ""}
                      disabled="disabled"
                    />
                  </div>
                  <div>
                    <table className="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <td> Passenger Id </td>
                          <td> First Name</td>
                          <td> Middle Name </td>
                          <td> First Name</td>
                          <td> Age</td>
                          <td> Gender</td>
                        </tr>
                      </thead>
                      <tbody>
                        {passengerList.map((passenger) => (
                          <tr key={passenger.id}>
                            <td>
                              <input
                                placeholder="Passenger Id"
                                name="id"
                                className="form-control"
                                value={passenger.id || ""}
                                disabled="disabled"
                              />
                            </td>
                            <td>
                              <input
                                placeholder="First Name"
                                name="firstName"
                                className="form-control"
                                value={firstName || ""}
                                onChange={(e) => {
                                  setFirstName(e.target.value);
                                }}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Middle Name"
                                name="middleName"
                                className="form-control"
                                value={middleName || ""}
                                onChange={(e) => {
                                  setMiddleName(e.target.value);
                                }}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Last Name"
                                name="lastName"
                                className="form-control"
                                value={lastName || ""}
                                onChange={(e) => {
                                  setLastName(e.target.value);
                                }}
                              />
                            </td>
                            <td>
                              <input
                                placeholder="Age"
                                name="age"
                                className="form-control"
                                value={age || ""}
                                onChange={(e) => {
                                  setAge(e.target.value);
                                }}
                              />
                            </td>
                            <td>
                              <select
                                className="form-control"
                                name="gender"
                                value={gender || ""}
                                onChange={(e) => {
                                  setGender(e.target.value);
                                }}
                              >
                                <option
                                  placeholder="Prefer not to say"
                                  value="Prefer not to say"
                                >
                                  -
                                </option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                                <option value="Other">Other</option>
                              </select>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>

                  <button className="btn btn-success" onClick={updateBooking}>
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
      ) : (
        history.push("/home")
      )}
    </div>
  );
}

export default UpdateBooking;
