package com.synerzip.manager;

import com.synerzip.dto.Airport;
import com.synerzip.dto.FlightDto;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AirportManager implements ManagerService {

  private static final String FLIGHT_DATA_TYPE = "flightData";
  // Make SingleTon class
  private static AirportManager airportManager = null;
  private Airport airport;

  public static AirportManager getInstance() {
    if (airportManager == null) {
      airportManager = new AirportManager();
      }
    return airportManager;
  }

  public void startAppService(){
    initConfig();
    takeUserInputFile();
  }

  private void takeUserInputFile() {

    final Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter flight data file in json format:");
    System.out.flush();
    String filename = scanner.nextLine();
    File file = new File(filename);

    String jsonDataType = JsonFileManager.getType(file);
    if (jsonDataType.equals(FLIGHT_DATA_TYPE)) {
      startFlightService(file);
    } else {
      // Start crew  Service
    }
  }

  private void initConfig() {
    this.airport = new Airport();
    airport.setAirportId(1);
    airport.setAirportCode("Delhi");
    airport.setAirportName("Indira Gandhi International Airport");
    airport.setAirportCity("Delhi");
  }

  private void startFlightService(File file) {

    FlightDto flightDto = new FlightDto();
    try {
      flightDto = JsonFileManager.readFromJson(file, flightDto);
    } catch (IOException io) {
      io.printStackTrace();
    }
    new MenuManager(flightDto);
  }

  private void startCrewService() {}

  public Airport getAirport() {
    return airport;
  }

  @Override
  public String toString() {
    return "AirportManager{" + "airport=" + airport + '}';
  }
}
