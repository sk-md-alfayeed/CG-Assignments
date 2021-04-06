import axios from "axios";
import React, { Component } from "react";
import { Redirect, withRouter } from "react-router-dom";

class LoginComponentClass extends Component {
  constructor(props) {
    super(props);
    const token = localStorage.getItem("token");
    const role = localStorage.getItem("role");

    let loggedIn = true;
    if (token == null) {
      loggedIn = false;
    }
    this.state = {
      username: "",
      password: "",
      role,
      loggedIn,
    };
    this.onChange = this.onChange.bind(this);
    this.submitForm = this.submitForm.bind(this);
  }

  onChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  submitForm(event) {
    event.preventDefault();
    // const { username, password } = this.state;

    // //login
    // if (username === "admin" && password === "admin") {
    //   localStorage.setItem("token", "ffgcuiiu");
    //   this.setState({
    //     loggedIn: true,
    //   });
    // }

    axios
      .post("http://localhost:3001/login", {
        username: this.state.username,
        password: this.state.password,
      })
      .then((response) => {
        if (!response.data.auth) {
          this.setState({
            loggedIn: false,
          });
        } else {
          localStorage.setItem("token", response.data.token);
          localStorage.setItem("username", response.data.result[0].username);
          localStorage.setItem("role", response.data.result[0].role);

          this.setState({
            loggedIn: true,
            role: response.data.result[0].role,
          });
        }
      });
  }

  render() {
    if (this.state.loggedIn && this.state.role === "ADMIN") {
      return <Redirect to="/adminDashboard" />;
    } else if (this.state.loggedIn && this.state.role === "USER") {
      return <Redirect to="/userDashboard" />;
    }

    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <div className="card-body"></div>
              <form onSubmit={this.submitForm}>
                <h3 className="text-center">Sign In</h3>
                <div className="form-group">
                  <label>Username</label>
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Enter username"
                    name="username"
                    defaultValue={this.state.username}
                    onChange={this.onChange}
                  />
                </div>

                <div className="form-group">
                  <label>Password</label>
                  <input
                    type="password"
                    className="form-control"
                    placeholder="Enter password"
                    name="password"
                    defaultValue={this.state.password}
                    onChange={this.onChange}
                  />
                </div>

                <div className="form-group">
                  <div className="custom-control custom-checkbox">
                    <input
                      type="checkbox"
                      className="custom-control-input"
                      id="customCheck1"
                    />
                    <label
                      className="custom-control-label"
                      htmlFor="customCheck1"
                    >
                      Remember me
                    </label>
                  </div>
                </div>

                <button type="submit" className="btn btn-primary btn-block">
                  Submit
                </button>
                <p className="forgot-password text-right">
                  Forgot <a href="/forgot">password?</a>
                </p>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(LoginComponentClass);
