package com.synerzip.dto;

import java.util.Date;

public class FlightData {

  private Long flightId;
  private String name;
  private String arrival;
  private String departure;
  private int passengers;
  private String destinationPort;
  private String sourcePort;

  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public int getPassengers() {
    return passengers;
  }

  public void setPassengers(int passengers) {
    this.passengers = passengers;
  }

  public String getDestinationPort() {
    return destinationPort;
  }

  public void setDestinationPort(String destinationPort) {
    this.destinationPort = destinationPort;
  }

  public String getSourcePort() {
    return sourcePort;
  }

  public void setSourcePort(String sourcePort) {
    this.sourcePort = sourcePort;
  }

  @Override
  public String toString() {
    return "FlightData{" +
        "flightId=" + flightId +
        ", name='" + name + '\'' +
        ", arrival='" + arrival + '\'' +
        ", departure='" + departure + '\'' +
        ", passengers=" + passengers +
        ", destinationPort='" + destinationPort + '\'' +
        ", sourcePort='" + sourcePort + '\'' +
        '}';
  }
}
