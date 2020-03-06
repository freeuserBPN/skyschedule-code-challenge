package com.synerzip.manager;

import com.synerzip.dto.FlightDto;
import java.util.Scanner;
import com.synerzip.service.FlightTrackingServiceImpl;

public class MenuManager {

  public static Scanner scanner = new Scanner(System.in);

  private FlightTrackingServiceImpl flightTrackingService;

  public MenuManager(FlightDto flightData) {
    this.flightTrackingService = new FlightTrackingServiceImpl(flightData);
    initMenu();
  }

  public static int showMenu() {
    int option = 0;
    System.out.println("Menu:");
    System.out.println("1.Flight Status");
    System.out.println("2.Incoming Flights");
    System.out.println("3.Outgoing Flights");
    System.out.println("4.Print flight names");
    System.out.println("5.Quit Program");
    System.out.println("Enter Option from above...");

    option = scanner.nextInt();

    return option;
  }

  private void initMenu() {

    try {
      // Setting default option to 0
      int menuOption = 0;
      do {
        menuOption = showMenu();
        switch (menuOption) {
          case 1:
            processFlightStatus();
            break;
          case 2:
            flightTrackingService.processIncomingFlights();
            break;
          case 3:
            flightTrackingService.processOutgoingFlight();
            break;
          case 4:
            flightTrackingService.printFlightNames();
            break;
          case 5:
            System.out.println("Quitting Program...");
            System.exit(0);
            break;
          default:
            System.out.println("Sorry, please enter valid Option");
        }

      } while (menuOption != 5);

      System.out.println("Thanks for using this Program...");

    } catch (Exception ex) {
      System.out.println("Sorry problem occured within Program");
      scanner.next();
    } finally {
      scanner.close();
    }
  }

  private void processFlightStatus() {
    System.out.println("Enter Flight name ");
    final String flightName = scanner.next();
    if (flightName.isEmpty()) {
      System.out.println("Please enter valid flight name");
      return;
    }
    flightTrackingService.processFlightStatus(flightName);
  }
}
