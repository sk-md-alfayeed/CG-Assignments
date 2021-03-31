import axios from "axios";
import { useState, useEffect } from "react";
export const CurrentWeather = () => {
  const [data, setData] = useState();
  let lat = 0.0;
  let lon = 0.0;
  useEffect(() => {
    return axios
      .get(`url`)
      .then((res) => setData(res.data))
      .catch((err) => console.log(err));
  }, []);
  return data;
};

export const DailyWeather = () => {
  const [data, setData] = useState();
  let lat = 0.0;
  let lon = 0.0;
  useEffect(() => {
    return axios
      .get(`url`)
      .then((res) => setData(res.data.forecast.forecastday))
      .catch((err) => console.log(err));
  }, []);
  return data;
};

export const HourlyWeather = () => {
  const [data, setData] = useState();
  let lat = 0.0;
  let lon = 0.0;
  useEffect(() => {
    return axios
      .get(`url`)
      .then((res) => setData(res.data.forecast.forecastday))
      .catch((err) => console.log(err));
  }, []);
  return data;
};
