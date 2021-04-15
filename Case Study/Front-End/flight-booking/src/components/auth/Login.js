import React, { useState, useEffect } from "react";
import { useHistory, withRouter } from "react-router-dom";
import axios from "axios";

function Login() {
  const history = useHistory();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const login = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:3001/login", {
        username: username,
        password: password,
      })
      .then((response) => {
        if (!response.data.auth) {
          history.push("/login");
        } else {
          localStorage.setItem("token", response.data.token);
          localStorage.setItem("username", response.data.result[0].username);
          localStorage.setItem("role", response.data.result[0].role);
          history.push("/home");
        }
      });

    //   axios
    //     .post("http://localhost:3001/login", {
    //       username: username,
    //       password: password,
    //     })
    //     .then((response) => {
    //       if (!response.data.auth) {
    //         setLoginStatus(false);
    //         isLoggedIn = false;
    //       } else {
    //         localStorage.setItem("token", response.data.token);
    //         localStorage.setItem("username", response.data.result[0].username);
    //         localStorage.setItem("role", response.data.result[0].role);

    //         setLoginStatus(true);
    //         // setRole(response.data.result[0].role);
    //         isLoggedIn = true;
    //         role = response.data.result[0].role;
    //       }
    //     });
  };

  //   const userAuthenticated = () => {
  //     Axios.get("http://localhost:3001/isUserAuth", {
  //       headers: {
  //         "x-access-token": localStorage.getItem("token"),
  //       },
  //     }).then((response) => {
  //       console.log(response);
  //     });

  //   };

  useEffect(() => {
    // console.log("Mount");
    axios.get("http://localhost:3001/login").then((response) => {
      if (response.data.loggedIn === true) {
      }

      if (localStorage.getItem("token")) {
        history.push("/home");
      }
    });
  }, [history]);

  // if (loginStatus && role === "ADMIN") {
  //   console.log("-----");
  //   return <Redirect to="/adminDashboard" />;
  // } else if (loginStatus && role === "USER") {
  //   console.log("++++");
  //   return <Redirect to="/userDashboard" />;
  // }
  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <div className="card-body"></div>
            <form onSubmit={login}>
              <h3 className="text-center">Sign In</h3>
              <div className="form-group">
                <label>Username</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter username"
                  name="username"
                  value={username}
                  onChange={(e) => {
                    setUsername(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  name="password"
                  value={password}
                  onChange={(e) => {
                    setPassword(e.target.value);
                  }}
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

export default withRouter(Login);
