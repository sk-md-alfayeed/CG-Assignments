import React, { useState, useEffect } from "react";
import { useParams, useHistory } from "react-router-dom";
import FlightService from "../../../services/FlightService";

function AddOrUpdateAirport() {
  const history = useHistory();
  const { id } = useParams();
  const [airportId, setAirportId] = useState("");
  const [airportCode, setAirportCode] = useState("");
  const [airportName, setAirportName] = useState("");

  useEffect(() => {
    if (id === "add") {
      return;
    } else {
      FlightService.getAirport(id)
        .then((response) => {
          let airport = response.data;
          setAirportId(airport.id);
          setAirportCode(airport.airportCode);
          setAirportName(airport.airportName);
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  }, [id]);

  const save = (e) => {
    e.preventDefault();
    let airport = {
      id: airportId,
      airportCode: airportCode,
      airportName: airportName,
    };
    if (id === "add") {
      FlightService.addAirport(airport)
        .then((res) => {
          history.push("/add_or_update_airport/add");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    } else {
      FlightService.updateAirport(airport)
        .then((res) => {
          history.push("/add_or_update_airport/:id");
        })
        .catch((error) => console.error(`Error :  ${error}`));
    }
  };

  const getTitle = () => {
    if (id === "add") {
      return <h3 className="text-center">Add Airport</h3>;
    } else {
      return <h3 className="text-center">Update Airport</h3>;
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
                  placeholder="Airport Id"
                  name="airpordid"
                  value={airportId || ""}
                  onChange={(e) => {
                    setAirportId(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Airport Code</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Airport Code"
                  name="airportCode"
                  value={airportCode || ""}
                  onChange={(e) => {
                    setAirportCode(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Airport Name</label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Airport Name"
                  name="airportName"
                  value={airportName || ""}
                  onChange={(e) => {
                    setAirportName(e.target.value);
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
export default AddOrUpdateAirport;
