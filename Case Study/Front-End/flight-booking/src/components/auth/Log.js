import React, { useEffect } from "react";
import axios from "axios";
import { useHistory } from "react-router";
import validate from "../forms/LoginFormValidation";
import useForm from "../forms/useForm";

function Log() {
  const { values, errors, handleChange, handleSubmit } = useForm(
    login,
    validate
  );
  const history = useHistory();

  useEffect(() => {
    axios.get("http://localhost:3001/login").then((response) => {
      if (response.data.loggedIn === true) {
      }

      if (localStorage.getItem("token")) {
        history.push("/home");
      }
    });
  }, [history]);

  function login() {
    axios
      .post("http://localhost:3001/login", {
        username: values.username,
        password: values.password,
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
  }

  return (
    <div className="section is-fullheight">
      <div className="container">
        <div className="column is-4 is-offset-4">
          <div className="box">
            <form onSubmit={handleSubmit} noValidate>
              <div className="field">
                <label className="label">Username</label>
                <div className="control">
                  <input
                    autoComplete="off"
                    className={`input ${errors.username && "is-danger"}`}
                    type="text"
                    name="username"
                    onChange={handleChange}
                    value={values.username || ""}
                    required
                  />
                  {errors.username && (
                    <p className="help is-danger">{errors.username}</p>
                  )}
                </div>
              </div>
              <div className="field">
                <label className="label">Password</label>
                <div className="control">
                  <input
                    className={`input ${errors.password && "is-danger"}`}
                    type="password"
                    name="password"
                    onChange={handleChange}
                    value={values.password || ""}
                    required
                  />
                </div>
                {errors.password && (
                  <p className="help is-danger">{errors.password}</p>
                )}
              </div>
              <button
                type="submit"
                className="button is-block is-info is-fullwidth"
              >
                Login
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Log;
