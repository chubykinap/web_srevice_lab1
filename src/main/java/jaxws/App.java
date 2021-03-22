package jaxws;

import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:8080/FlightsService",
                new FlightService());
    }
}
