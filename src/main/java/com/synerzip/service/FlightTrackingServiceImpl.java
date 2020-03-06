package com.synerzip.service;

import com.synerzip.dto.FlightData;
import com.synerzip.dto.FlightDto;
import com.synerzip.manager.AirportManager;
import com.synerzip.manager.JsonFileManager;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightTrackingServiceImpl implements FlightTrackingService {

  private static final Logger logger = LoggerFactory.getLogger(FlightTrackingServiceImpl.class);

  private final FlightDto flightData;
  private AirportManager airportManager;

  public FlightTrackingServiceImpl(FlightDto flightData) {
    this.flightData = flightData;
    this.airportManager = AirportManager.getInstance();
  }

  @Override
  public void processIncomingFlights() {
    List<FlightData> flightDataList =
        flightData.getData().stream()
            .filter(f -> !f.getSourcePort().equals(airportManager.getAirport().getAirportCode()))
            .collect(Collectors.toList());
    FlightDto flightDto = getDefaultOutputModel();
    flightDto.setData(flightDataList);
    JsonFileManager.writeToJson(flightDto);
  }

  @Override
  public void processFlightStatus(final String flightName) {

    List<FlightData> flight =
        flightData.getData().stream().filter(f -> f.getName().equals(flightName)).collect(Collectors.toList());
    logger.info("Flight status for flight name {} has been successfully processed!!!0",flightName);
    FlightDto flightDto = getDefaultOutputModel();
    flightDto.setData(flight);
    JsonFileManager.writeToJson(flightDto);
  }

  @Override
  public void printFlightNames() {
    flightData.getData().forEach(f-> {
      System.out.println("Flight Name = "+f.getName());
    });
  }

  private FlightDto getDefaultOutputModel() {
    FlightDto flightDto = new FlightDto();
    flightDto.setType("flight-data");
    flightDto.setDataSource("Manager-service");
    return flightDto;
  }

  @Override
  public void processOutgoingFlight() {
    List<FlightData> flightDataList =
        flightData.getData().stream()
            .filter(f -> f.getSourcePort().equals(airportManager.getAirport().getAirportCode()))
            .collect(Collectors.toList());
    FlightDto flightDto = new FlightDto();
    flightDto.setData(flightDataList);
    JsonFileManager.writeToJson(flightDto);
  }
}
