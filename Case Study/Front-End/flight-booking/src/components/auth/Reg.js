import React from "react";
import axios from "axios";
import validate from "../forms/RegisterFormValidation";
import useForm from "../forms/useForm";
import { useHistory } from "react-router";

function Reg() {
  const { values, errors, handleChange, handleSubmit } = useForm(
    register,
    validate
  );
  const history = useHistory();

  function register() {
    axios
      .post("http://localhost:3001/register", {
        fullname: values.fullname,
        username: values.username,
        email: values.email,
        password: values.password,
      })
      .then(() => {});
    history.push("/login");
  }

  return (
    <div
      className="section is-fullheig
    ht"
    >
      <div className="container">
        <div className="column is-4 is-offset-4">
          <div className="box">
            <form onSubmit={handleSubmit} noValidate>
              <div className="field">
                <label className="label">Fullname</label>
                <div className="control">
                  <input
                    autoComplete="off"
                    className={`input ${errors.fullname && "is-danger"}`}
                    type="text"
                    name="fullname"
                    onChange={handleChange}
                    value={values.fullname || ""}
                    required
                  />
                  {errors.fullname && (
                    <p className="help is-danger">{errors.fullname}</p>
                  )}
                </div>
              </div>
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
                <label className="label">Email</label>
                <div className="control">
                  <input
                    autoComplete="off"
                    className={`input ${errors.email && "is-danger"}`}
                    type="email"
                    name="email"
                    onChange={handleChange}
                    value={values.email || ""}
                    required
                  />
                  {errors.email && (
                    <p className="help is-danger">{errors.email}</p>
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
                Signup
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Reg;
