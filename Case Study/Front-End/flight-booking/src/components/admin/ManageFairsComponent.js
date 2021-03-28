import React, { Component } from "react";
import FlightService from "../../services/FlightService";

class ManageFairsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fairs: [],
    };
    this.addFair = this.addFair.bind(this);

    this.deleteFair = this.deleteFair.bind(this);
  }

  componentDidMount() {
    FlightService.getAllFairs().then((response) => {
      this.setState({ fairs: response.data });
    });
  }

  addFair() {
    this.props.history.push("/addFair/add");
  }

  editFair(id) {
    this.props.history.push(`/editFair/${id}`);
  }

  deleteFair(flightId) {
    FlightService.deleteFair(flightId).then((res) => {
      this.setState({
        fairs: this.state.fairs.filter((fair) => fair.flightId !== flightId),
      });
    });
  }

  render() {
    return (
      <div>
        <h1 className="text-center"> Fairs List</h1>
        <br></br>
        <div className="text-center">
          <button className="btn btn-primary" onClick={this.addFair}>
            {" "}
            Add Fair
          </button>
        </div>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <td> Fair Id</td>
                <td> Flight Id</td>
                <td> Flight Fair</td>
                <td> Edit</td>
                <td> Delete</td>
              </tr>
            </thead>
            <tbody>
              {this.state.fairs.map((fair) => (
                <tr key={fair.id}>
                  <td> {fair.id}</td>
                  <td> {fair.flightId}</td>
                  <td> {fair.flightFair}</td>
                  <td>
                    <button
                      onClick={() => this.editFair(fair.flightId)}
                      className="btn btn-info"
                    >
                      Edit
                    </button>
                  </td>

                  <td>
                    <button
                      onClick={() => this.deleteFair(fair.flightId)}
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
}

export default ManageFairsComponent;
