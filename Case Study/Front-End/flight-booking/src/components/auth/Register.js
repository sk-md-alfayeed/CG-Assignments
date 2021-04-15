import React, { useState } from "react";
import Axios from "axios";

function Register() {
  const [fullnameReg, setFullnameReg] = useState("");
  const [usernameReg, setUsernameReg] = useState("");
  const [emailReg, setEmailReg] = useState("");
  const [passwordReg, setPasswordReg] = useState("");

  const register = () => {
    Axios.post("http://localhost:3001/register", {
      fullname: fullnameReg,
      username: usernameReg,
      email: emailReg,
      password: passwordReg,
    }).then((response) => {
      console.log(response);
    });
  };

  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <div className="card-body"></div>
            <form>
              <h3 className="text-center">Sign Up</h3>

              <div className="form-group">
                <label>Full name</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Full name"
                  name="fullnameReg"
                  value={fullnameReg}
                  onChange={(e) => {
                    setFullnameReg(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Username</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Username"
                  name="usernameReg"
                  value={usernameReg}
                  onChange={(e) => {
                    setUsernameReg(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Email address</label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Enter email"
                  name="emailReg"
                  value={emailReg}
                  onChange={(e) => {
                    setEmailReg(e.target.value);
                  }}
                />
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  name="passwordReg"
                  value={passwordReg}
                  onChange={(e) => {
                    setPasswordReg(e.target.value);
                  }}
                />
              </div>

              <button onClick={register} className="btn btn-primary btn-block">
                Sign Up
              </button>
            </form>
            <br></br>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
