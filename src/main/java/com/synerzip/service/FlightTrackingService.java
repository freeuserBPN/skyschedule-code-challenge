package com.synerzip.service;

import java.io.File;

public interface FlightTrackingService {

  void processIncomingFlights();
  void processOutgoingFlight();
  void processFlightStatus(String flightName);
  void printFlightNames();
}
