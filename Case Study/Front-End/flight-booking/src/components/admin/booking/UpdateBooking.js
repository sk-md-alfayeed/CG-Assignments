import React, { useState, useEffect } from "react";

import { useHistory } from "react-router-dom";
import FlightService from "../../services/FlightService";

function UpdateBooking() {
  const history = useHistory();
  const username = localStorage.getItem("username");
  const [bookingList, setBookingList] = useState([]);
  // const [booking, setBooking] = useState([]);
  // const [passenger, setPassenger] = useState([]);

  const [passengerId, setPassengerId] = useState([]);
  const [firstName, setFirstName] = useState([]);
  const [middleName, setMiddleName] = useState([]);
  const [lastName, setLastName] = useState([]);
  const [age, setAge] = useState([]);
  const [gender, setGender] = useState([]);

  useEffect(() => {
    FlightService.getUserBooking(username)
      .then((response) => {
        setBookingList(response.data.bookingList);
        // setBooking(response.data.bookingList[0]);
        // setPassenger(response.data.bookingList[0].passenger);

        setPassengerId(response.data.bookingList[0].id);
        setFirstName(response.data.bookingList[0].firstName);
        setMiddleName(response.data.bookingList[0].middleName);
        setLastName(response.data.bookingList[0].lastName);
        setAge(response.data.bookingList[0].age);
        setGender(response.data.bookingList[0].gender);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, [username]);

  const save = (event) => {
    event.preventDefault();

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

    // let booking = {
    //   // id: booking.id + "-" + booking.flight.airline.airlineName,
    //   // flight: booking.flight,
    //   // passengerList: myPassengerList,
    //   // active: true,
    // };

    let userBooking = {
      username: username,
      bookingList: bookingList,
    };

    FlightService.updateUserBooking(userBooking).then((res) => {
      history.push("/userBooking");
    });
  };

  const cancelBooking = (booking) => {
    booking.active = !booking.active;
    FlightService.cancelBooking(booking).then((res) => {
      this.setState({
        bookings: this.state.bookings,
      });
    });
  };
  return <div></div>;
}

export default UpdateBooking;
