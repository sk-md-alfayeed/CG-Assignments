import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import FlightService from "../../services/FlightService";

function Acknowledgment() {
  const { id } = useParams();
  const [booking, setBooking] = useState({});
  const [payment, setPayment] = useState({});

  useEffect(() => {
    FlightService.getBooking(id)
      .then((response) => {
        setBooking(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
    axios
      .post("http://localhost:3002/getPayment", {
        bookingid: id,
      })
      .then((response) => {
        console.log(response.data);
        setPayment(response.data);
      });
  }, [id]);

  return (
    <div>
      <div className="container">
        <div className="row mt-5 pt-5">
          <div className="col-md-6 offset-md-3 offset-md-3 grid-margin">
            <div className="card h-100">
              <h4 className="card-header">Acknowledgment</h4>
              <div className="card-body">
                <form className="text-center">
                  <h4>Thank You For the Booking</h4>
                  <br />
                  <h6>Booking Id</h6>
                  <p>{id}</p>
                  <h6>Payment Id</h6>
                  <p>{payment.paymentid}</p>
                  <h6>Signature</h6>
                  <p>{payment.signature}</p>
                  <h6>Amount Paid</h6>
                  <p>{payment.totalamount}</p>
                  <p>
                    Status : {booking.active === true ? "Booked" : "Not Booked"}
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Acknowledgment;
