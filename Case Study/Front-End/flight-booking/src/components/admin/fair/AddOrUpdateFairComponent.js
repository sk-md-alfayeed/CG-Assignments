import React, { Component } from "react";
import { withRouter } from "react-router";
import FlightService from "../../../services/FlightService";

class AddOrUpdateFairComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      prevId: this.props.match.params.id,
      id: "",
      flightId: "",
      flightName: "",
      flightFair: 0,
    };

    // this.changeFairIdHandler = this.changeFairIdHandler.bind(this);
    // this.changeFlightIdHandler = this.changeFlightIdHandler.bind(this);
    // this.changeFairHandler = this.changeFairHandler.bind(
    //   this
    // );
  }

  componentDidMount() {
    if (this.state.prevId === "add") {
      return;
    } else {
      FlightService.getFair(this.state.prevId).then((response) => {
        let fair = response.data;
        this.setState({
          id: fair.id,
          flightId: fair.flightId,
          flightName: fair.flightName,
          flightFair: fair.flightFair,
        });
      });
    }
  }

  //Value Change Events
  changeFairIdHandler = (event) => {
    this.setState({ id: event.target.value });
  };
  changeFlightIdHandler = (event) => {
    this.setState({ flightId: event.target.value });
  };
  changeFlightNameHandler = (event) => {
    this.setState({ flightName: event.target.value });
  };
  changeFlightFairHandler = (event) => {
    this.setState({ flightFair: event.target.value });
  };

  //Update Fair

  saveOrUpdateFair = (e) => {
    e.preventDefault();
    let fair = {
      id: this.state.id,
      flightId: this.state.flightId,
      flightName: this.state.flightName,
      flightFair: this.state.flightFair,
    };
    if (this.state.prevId === "add") {
      FlightService.addFair(fair).then((res) => {
        this.props.history.push("/manageFairs");
      });
    } else {
      FlightService.updateFair(fair).then((res) => {
        this.props.history.push("/manageFairs");
      });
    }
  };

  cancel() {
    this.props.history.push("/manageFairs");
  }
  getTitle() {
    if (this.state.prevId === "add") {
      return <h3 className="text-center">Add Fair</h3>;
    } else {
      return <h3 className="text-center">Update Fair</h3>;
    }
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              {this.getTitle()}
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> Fair Id: </label>
                    <input
                      placeholder="Fair Id"
                      name="id"
                      className="form-control"
                      value={this.state.id}
                      onChange={this.changeFairIdHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Flight Id: </label>
                    <input
                      placeholder="Flight Id"
                      name="flightId"
                      className="form-control"
                      value={this.state.flightId}
                      onChange={this.changeFlightIdHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Flight Name: </label>
                    <input
                      placeholder="Flight Name"
                      name="flightName"
                      className="form-control"
                      value={this.state.flightName}
                      onChange={this.changeFlightNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Fair: </label>
                    <input
                      placeholder="Fair"
                      name="flightFair"
                      className="form-control"
                      value={this.state.flightFair}
                      onChange={this.changeFlightFairHandler}
                    />
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.saveOrUpdateFair}
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
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
}

export default withRouter(AddOrUpdateFairComponent);
