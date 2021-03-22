package client;

import client.generated.Flight;
import client.generated.FlightService;
import client.generated.JavaxpFlightService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws IOException {
        String request = new Scanner(System.in).nextLine();
        JavaxpFlightService service = new JavaxpFlightService();
        FlightService flightService = service.getFlightServicePort();
        List<Flight> flights = null;
        try {
            flights = flightService.getFlights(request);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for (Flight flight : flights) {
            System.out.println("Полет " + flight.getFlightNumber() +
                    " " + flight.getDepartureDate().toString() +
                    " из " + flight.getDepartureCity() +
                    " в " + flight.getArrivalCity());
        }
    }
}
