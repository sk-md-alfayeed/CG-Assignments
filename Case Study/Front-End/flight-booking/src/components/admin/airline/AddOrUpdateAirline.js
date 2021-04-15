import React, { useState, useEffect } from "react";

import { useParams, useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function AddOrUpdateAirline() {
  const history = useHistory();
  const { id } = useParams();
  const [airlineId, setAirlineId] = useState("");
  const [airlineNo, setAirlineNo] = useState("");
  const [airlineName, setAirlineName] = useState("");

  useEffect(() => {
    if (id === "add") {
      return;
    } else {
      FlightService.getAirline(id)
        .then((response) => {
          let airline = response.data;
          setAirlineId(airline.id);
          setAirlineNo(airline.airlineNo);
          setAirlineName(airline.airlineName);
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  }, [id]);

  const save = (e) => {
    e.preventDefault();
    let airline = {
      id: airlineId,
      airlineNo: airlineNo,
      airlineName: airlineName,
    };
    if (id === "add") {
      FlightService.addAirline(airline)
        .then((res) => {
          history.push("/addOrUpdateAirline/add");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    } else {
      FlightService.updateAirline(airline).then((res) => {
        history
          .push("/addOrUpdateAirline/:id")
          .catch((error) => console.error(`Error :  ${error}`));
      });
    }
  };

  const getTitle = () => {
    if (id === "add") {
      return <h3 className="text-center">Add Airline</h3>;
    } else {
      return <h3 className="text-center">Update Airline</h3>;
    }
  };

  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <div className="card-body"></div>
            <form>
              {getTitle()}

              <div className="form-group">
                <label>Id</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Id"
                  name="id"
                  value={airlineId}
                  onChange={(e) => {
                    setAirlineId(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Airline No</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Airline No"
                  name="airlineNo"
                  value={airlineNo}
                  onChange={(e) => {
                    setAirlineNo(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Airline Name</label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Airline Name"
                  name="airlineName"
                  value={airlineName}
                  onChange={(e) => {
                    setAirlineName(e.target.value);
                  }}
                />
              </div>

              <button onClick={save} className="btn btn-primary btn-block">
                Save
              </button>
            </form>
            <br></br>
          </div>
        </div>
      </div>
    </div>
  );
}
export default AddOrUpdateAirline;
