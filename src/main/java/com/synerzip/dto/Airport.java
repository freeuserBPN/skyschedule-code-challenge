package com.synerzip.dto;

public class Airport {

  private int airportId;

  private String airportName;

  private String airportCode;

  private String airportCity;

  public int getAirportId() {
    return airportId;
  }

  public void setAirportId(int airportId) {
    this.airportId = airportId;
  }

  public String getAirportName() {
    return airportName;
  }

  public void setAirportName(String airportName) {
    this.airportName = airportName;
  }

  public String getAirportCode() {
    return airportCode;
  }

  public void setAirportCode(String airportCode) {
    this.airportCode = airportCode;
  }

  public String getAirportCity() {
    return airportCity;
  }

  public void setAirportCity(String airportCity) {
    this.airportCity = airportCity;
  }

  @Override
  public String toString() {
    return "Airport{" +
        "airportId=" + airportId +
        ", airportName='" + airportName + '\'' +
        ", airportCode='" + airportCode + '\'' +
        ", airportCity='" + airportCity + '\'' +
        '}';
  }
}
