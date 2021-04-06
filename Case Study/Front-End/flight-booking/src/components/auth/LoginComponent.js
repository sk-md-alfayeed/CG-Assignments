import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import Axios from "axios";

function LoginComponent() {
  let history = useHistory();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [setLoginStatus] = useState(false);

  Axios.defaults.withCredentials = true;

  const login = (event) => {
    event.preventDefault();
    Axios.post("http://localhost:3001/login", {
      username: username,
      password: password,
    }).then((response) => {
      if (!response.data.auth) {
        setLoginStatus(false);
        history.push("/login");
      } else {
        localStorage.setItem("token", response.data.token);
        setLoginStatus(true);
        history.push("/adminDashboard");
      }
    });
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
    Axios.get("http://localhost:3001/login").then((response) => {
      if (response.data.loggedIn === true) {
        setLoginStatus(response.data.user[0].username);
      }
    });
    if (localStorage.getItem("token")) {
      setLoginStatus(true);
      history.push("/adminDashboard");
    }
  }, []);

  return (
    <div>
      <form>
        <h3>Sign In</h3>
        <div className="form-group">
          <label>Username</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter username"
            name="username"
            defaultValue={username}
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
            defaultValue={password}
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
            <label className="custom-control-label" htmlFor="customCheck1">
              Remember me
            </label>
          </div>
        </div>

        <button onClick={login} className="btn btn-primary btn-block">
          Submit
        </button>
        <p className="forgot-password text-right">
          Forgot <a href="/forgot">password?</a>
        </p>
      </form>
    </div>
  );
}

export default LoginComponent;
