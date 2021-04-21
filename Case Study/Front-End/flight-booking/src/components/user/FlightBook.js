import axios from "axios";
import React, { useState, useEffect } from "react";
import { useHistory, useParams } from "react-router-dom";
import FlightService from "../../services/FlightService";
import { Button, Table } from "react-bootstrap";

import validate from "../forms/PassengerFormValidation";
import useForm from "../forms/useForm";

//------------------------------------------------------------------------
//loading Razorpay Webpage
function loadScript(src) {
  return new Promise((resolve) => {
    const script = document.createElement("script");
    script.src = src;
    script.onload = () => {
      resolve(true);
    };
    script.onerror = () => {
      resolve(false);
    };
    document.body.appendChild(script);
  });
}

const __DEV__ = document.domain === "localhost";

//-------------------------------------------------------------------------
//randomId Generator
const getRandomId = (min = 0, max = 500000) => {
  min = Math.ceil(min);
  max = Math.floor(max);
  const num = Math.floor(Math.random() * (max - min + 1)) + min;
  return num.toString().padStart(4, "0");
};
const randomNumber = getRandomId();

//-------------------------------------------------------------------------
//randomId Generator

function uniqueId(stringLength, possible) {
  stringLength = stringLength || 10;
  possible = possible || "ABCDEFGHJKMNPQRSTUXY";
  var text = "";

  for (var i = 0; i < stringLength; i++) {
    var character = getCharacter(possible);
    while (text.length > 0 && character === text.substr(-1)) {
      character = getCharacter(possible);
    }
    text += character;
  }

  return text;
}

function getCharacter(possible) {
  return possible.charAt(Math.floor(Math.random() * possible.length));
}

const randomPnr = uniqueId();

// -------------------------------------------------------------------------
//main function
function FlightBook() {
  const { id } = useParams();
  const username = localStorage.getItem("username");

  const history = useHistory();
  const [flight, setFlight] = useState({});
  const [passengerList, setPassengerList] = useState([]);
  const [passengerId, setPassengerId] = useState(1);

  //Passenger form Validation
  const { values, errors, handleChange, handleSubmit } = useForm(
    callback,
    validate
  );

  useEffect(() => {
    FlightService.getSelectedFlight(id)
      .then((response) => {
        if (response.data) {
          setFlight(response.data);
        }
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, [id]);

  // .......................................................................
  //book flight
  const bookFlight = (response) => {
    console.log(response);

    let booking = {
      id: flight.id + "-" + flight.airline.airlineName + "-" + randomNumber,
      pnrNo: randomPnr,
      flight: flight,
      passengerList: passengerList,
      active: true,
      userId: username,
    };

    // .......................................................................
    //Save payment details to database
    axios
      .post("http://localhost:3002/addPayment", {
        paymentid: response.razorpay_payment_id,
        orderid: response.razorpay_order_id,
        signature: response.razorpay_signature,
        bookingid: booking.id,
        userid: username,
      })
      .then((response) => {
        console.log(response);
      });
    FlightService.bookFlight(booking)
      .then((response) => {
        history.push(
          `/acknowledgment/${
            flight.id + "-" + flight.airline.airlineName + "-" + randomNumber
          }`
        );
      })
      .catch((error) => console.error(`Error :  ${error}`));
  };

  function callback() {
    // history.push(`/booking/${id}`);
  }

  // .......................................................................
  //Add Passenger
  const addPassenger = () => {
    const errors = validate(values);
    if (Object.keys(errors).length === 0) {
      let passenger = {
        id: passengerId,
        firstName: values.firstname,
        middleName: values.middlename,
        lastName: values.lastname,
        age: values.age,
        gender: values.gender,
      };
      setPassengerId(passengerId + 1);
      setPassengerList([...passengerList, passenger]);
    }
  };

  //-------------------------------------------------------------------------
  //Payment Function
  async function displayRazorpay() {
    //userdata
    const info = {
      fare: flight.flightFare,
    };

    const res = await loadScript(
      "https://checkout.razorpay.com/v1/checkout.js"
    );

    if (!res) {
      alert("Razorpay SDK failed to load. Are you online?");
      return;
    }

    const data = await fetch("http://localhost:3002/razorpay", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(info),
    }).then((t) => t.json());

    console.log(data);

    const options = {
      key: __DEV__ ? "rzp_test_3qpMwKLiYT1YtE" : "PRODUCTION_KEY",
      currency: data.currency,
      amount: data.amount.toString(),
      order_id: data.id,
      name: flight.id,
      description: flight.airline.airlineName,
      image:
        "https://e7.pngegg.com/pngimages/953/550/png-clipart-pictogram-airplane-wikipedia-information-computer-icons-aircraft-icon-blue-logo.png",
      handler: function (response) {
        if (response.razorpay_payment_id) {
          bookFlight(response);
        }
        // alert(response.razorpay_payment_id);
        // alert(response.razorpay_order_id);
        // alert(response.razorpay_signature);
      },
      prefill: {
        name: username,
        email: "demo@demo.com",
        phone_number: "9899999999",
      },
    };
    const paymentObject = new window.Razorpay(options);
    paymentObject.open();
  }
  //---------------------------------------------------------------------

  return (
    <div>
      <div className="container">
        {Object.keys(flight).length !== 0 ? (
          <div className="card">
            <h4 className="card-header">Flight Details</h4>
            <div className="card-body">
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <td> Flight Id</td>
                    <td> Flight Name</td>
                    <td> Departure Airport</td>
                    <td> Destination Airport</td>
                    <td> Departure Date</td>
                    <td> Arrival Date</td>
                    <td> Departure Time</td>
                    <td> Arrival Time</td>
                    <td> Flight Fare</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td> {flight.id}</td>
                    <td> {flight.airline.airlineName}</td>
                    <td> {flight.departureAirport.airportCode}</td>
                    <td> {flight.destinationAirport.airportCode}</td>
                    <td> {flight.departureDate}</td>
                    <td> {flight.arrivalDate}</td>
                    <td> {flight.departureTime}</td>
                    <td> {flight.arrivalTime}</td>
                    <td>{flight.flightFare}</td>
                  </tr>
                </tbody>
              </Table>
            </div>
          </div>
        ) : null}
        {passengerList.length !== 0 ? (
          <div>
            <table className="table table-striped table-bordered">
              <thead>
                <tr>
                  <td> Passenger Id</td>
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
                    <td> {passenger.id}</td>
                    <td> {passenger.firstName}</td>
                    <td> {passenger.middleName}</td>
                    <td> {passenger.lastName}</td>
                    <td> {passenger.age}</td>
                    <td> {passenger.gender}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : null}
      </div>
      {passengerList.length < 1 ? (
        <div className="section is-fullheight">
          <div className="container">
            <div className="column is-4 is-offset-4">
              <div className="box">
                <form onSubmit={handleSubmit} noValidate>
                  <div className="field">
                    <label className="label">First Name</label>
                    <div className="control">
                      <input
                        autoComplete="off"
                        className={`input ${errors.firstname && "is-danger"}`}
                        type="text"
                        name="firstname"
                        onChange={handleChange}
                        value={values.firstname || ""}
                        required
                      />
                      {errors.firstname && (
                        <p className="help is-danger">{errors.firstname}</p>
                      )}
                    </div>
                  </div>
                  <div className="field">
                    <label className="label">Middle Name</label>
                    <div className="control">
                      <input
                        className={`input ${errors.middlename && "is-danger"}`}
                        type="text"
                        name="middlename"
                        onChange={handleChange}
                        value={values.middlename || ""}
                        required
                      />
                    </div>
                    {errors.middlename && (
                      <p className="help is-danger">{errors.middlename}</p>
                    )}
                  </div>
                  <div className="field">
                    <label className="label">Last Name</label>
                    <div className="control">
                      <input
                        autoComplete="off"
                        className={`input ${errors.lastname && "is-danger"}`}
                        type="text"
                        name="lastname"
                        onChange={handleChange}
                        value={values.lastname || ""}
                        required
                      />
                      {errors.lastname && (
                        <p className="help is-danger">{errors.lastname}</p>
                      )}
                    </div>
                  </div>
                  <div className="field">
                    <label className="label">Age</label>
                    <div className="control">
                      <input
                        autoComplete="off"
                        className={`input ${errors.age && "is-danger"}`}
                        type="number"
                        name="age"
                        onChange={handleChange}
                        value={values.age || ""}
                        required
                      />
                      {errors.age && (
                        <p className="help is-danger">{errors.age}</p>
                      )}
                    </div>
                  </div>

                  <div className="field">
                    <label className="label">Gender</label>
                    <div className="control">
                      <select
                        autoComplete="off"
                        className={`input ${errors.gender && "is-danger"}`}
                        name="gender"
                        onChange={handleChange}
                        value={values.gender || ""}
                        required
                      >
                        <option
                          placeholder="Prefer not to say"
                          value={"Prefer not to say"}
                        >
                          -
                        </option>
                        <option value="Female">Female</option>
                        <option value="Male">Male</option>
                        <option value="Other">Other</option>
                      </select>
                      {errors.gender && (
                        <p className="help is-danger">{errors.gender}</p>
                      )}
                    </div>
                  </div>
                  <button
                    type="submit"
                    className="button is-block is-info is-fullwidth"
                    onClick={addPassenger}
                  >
                    Add
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      ) : null}
      {passengerList.length === 1 ? (
        <div className="section is-fullheight">
          <div className="container">
            <div className="column is-4 is-offset-4">
              <Button
                className="btn btn-success text-center"
                id="submit"
                onClick={displayRazorpay}
                block
              >
                Pay
              </Button>
            </div>
          </div>
        </div>
      ) : null}
    </div>
  );
}

export default FlightBook;
