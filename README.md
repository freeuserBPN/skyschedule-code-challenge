Airport manager to track flights at his airport

Prerequisite:
Maven, 
jdk-8

Instructions to run this application

$ mvn compile

$ mvn exec:java -Dexec.mainClass="SkyScheduleApplication"

After above command you will be asked to enter file name

So you need to enter this -> flight.json

After that these below menu options will be shown:

Menu:

1.Flight Status

2.Incoming Flights

3.Outgoing Flights

4.Print flight names

5.Quit Program

Choose any option and check project root directory for the output json.

Output file name = FlightDetailsOutput.json
