import React, { useState, useEffect } from "react";
import { useParams, useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function AddOrUpdateFare() {
  const history = useHistory();
  const { id } = useParams();

  const [fareId, setFareId] = useState("");
  const [flightName, setFlightName] = useState("");
  const [flightFare, setFlightFare] = useState("");

  useEffect(() => {
    if (id === "add") {
      return;
    }
    FlightService.getFare(id)
      .then((response) => {
        let fare = response.data;
        setFareId(fare.id);
        setFlightName(fare.flightName);
        setFlightFare(fare.flightFare);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, [id]);

  const save = (event) => {
    event.preventDefault();
    let fare = {
      id: fareId,
      flightName: flightName,
      flightFare: flightFare,
    };
    if (id === "add") {
      FlightService.addFare(fare)
        .then((res) => {
          history.push("/manage_fare");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    } else {
      FlightService.updateFare(fare)
        .then((res) => {
          history.push("/manage_fare");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  };

  const cancel = () => {
    history.push("/manage_fare");
  };

  const getTitle = () => {
    if (id === "add") {
      return <h3 className="text-center">Add Fare</h3>;
    } else {
      return <h3 className="text-center">Update Fare</h3>;
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
                  <label> Fare Id: </label>
                  <input
                    placeholder="Fare Id"
                    name="id"
                    className="form-control"
                    value={fareId || ""}
                    disabled="disabled"
                  />
                </div>
                <div className="form-group">
                  <label> Flight Name: </label>
                  <input
                    placeholder="Flight Name"
                    name="flightName"
                    className="form-control"
                    value={flightName || ""}
                    disabled="disabled"
                  />
                </div>
                <div className="form-group">
                  <label> Fare: </label>
                  <input
                    placeholder="Fare"
                    name="flightFare"
                    className="form-control"
                    value={flightFare || ""}
                    onChange={(e) => {
                      setFlightFare(e.target.value);
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

export default AddOrUpdateFare;
