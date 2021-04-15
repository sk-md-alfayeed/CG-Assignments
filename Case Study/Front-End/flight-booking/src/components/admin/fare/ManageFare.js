import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function ManageFare() {
  const history = useHistory();

  const [fares, setFares] = useState([]);

  useEffect(() => {
    let unmounted = false;
    FlightService.getAllFares()
      .then((response) => {
        if (response.data !== null) {
          if (!unmounted) {
            setFares(response.data);
          }
        }
      })
      .catch((error) => console.error(`Error :  ${error}`));
    return () => {
      unmounted = true;
    };
  }, [fares]);

  const addFare = () => {
    history.push("/add_fare/add");
  };

  const updateFare = (id) => {
    history.push(`/update_fare/${id}`);
  };

  const deleteFare = (flightId) => {
    FlightService.deleteFare(flightId)
      .then(() => {
        setFares(fares.filter((fare) => fare.flightId !== flightId));
      })
      .catch((error) => console.error(`Error :  ${error}`));
  };

  return (
    <div>
      <h1 className="text-center"> Fares List</h1>
      <br></br>
      <div className="text-center">
        <button className="btn btn-primary" onClick={addFare}>
          Add Fare
        </button>
      </div>
      <br></br>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <td> Fare Id</td>
              <td> Flight Name</td>
              <td> Flight Fare</td>
              <td> Update</td>
              <td> Delete</td>
            </tr>
          </thead>
          <tbody>
            {fares.map((fare) => (
              <tr key={fare.id}>
                <td> {fare.id}</td>
                <td> {fare.flightName}</td>
                <td> {fare.flightFare}</td>
                <td>
                  <button
                    onClick={() => updateFare(fare.id)}
                    className="btn btn-info"
                  >
                    Update
                  </button>
                </td>

                <td>
                  <button
                    onClick={() => deleteFare(fare.id)}
                    className="btn btn-info"
                  >
                    Delete
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

export default ManageFare;
