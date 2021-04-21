import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import FlightService from "../../services/FlightService";

function UserBooking() {
  const username = localStorage.getItem("username");
  const history = useHistory();
  const [bookingList, setBookingList] = useState([]);

  useEffect(() => {
    FlightService.getBookingsByUserId(username)
      .then((response) => {
        if (response.data !== null) {
          setBookingList(response.data);
          console.log(response.data);
        }
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, [username]);

  const cancelBooking = (booking) => {
    booking.active = !booking.active;
    FlightService.cancelBooking(booking)
      .then((res) => {
        history.push("/user_booking");
      })
      .catch((error) => console.error(`Error :  ${error}`));
  };

  return (
    <div>
      <h1 className="text-center"> Bookings List</h1>
      <br></br>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <td> Booking Id</td>
              <td> Flight</td>
              <td> Passenger List</td>
              <td> Active</td>
              <td> Change Status</td>
            </tr>
          </thead>
          <tbody>
            {bookingList.map((booking) => (
              <tr key={booking.id}>
                <td> {booking.id}</td>
                <td>
                  {
                    <div className="row">
                      <table className="table table-striped table-bordered">
                        <thead>
                          <tr>
                            <td> Flight Id</td>
                            <td> Flight Name</td>
                            <td> Departure Airport</td>
                            <td> Destination Airport</td>
                            {/* <td> Departure Date</td>
                        <td> Arrival Date</td>
                        <td> Departure Time</td>
                        <td> Arrival Time</td> */}
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td> {booking.flight.airline.id}</td>
                            <td> {booking.flight.airline.airlineName}</td>
                            <td>
                              {" "}
                              {booking.flight.departureAirport.airportCode}
                            </td>
                            <td>
                              {" "}
                              {booking.flight.destinationAirport.airportCode}
                            </td>
                            {/* <td> {booking.flight.departureDate}</td>
                        <td> {booking.flight.arrivalDate}</td>
                        <td> {booking.flight.departureTime}</td>
                        <td> {booking.flight.arrivalTime}</td> */}
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  }
                </td>
                <td>
                  {
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
                          {booking.passengerList.map((passenger) => (
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
                  }
                </td>

                <td> {booking.active.toString()}</td>

                <td>
                  <button
                    onClick={() => cancelBooking(booking)}
                    className="btn btn-info"
                  >
                    Cancel
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default UserBooking;
