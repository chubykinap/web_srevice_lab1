package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "javaxp.FlightService")
public class FlightService {
    @WebMethod(operationName = "getFlights")
    public List<Flight> getFlights(String arg) {
        return new DbMethods().getFlights(arg);
    }

    @WebMethod(operationName = "addFlight")
    public int addFlight(String values) {
        return new DbMethods().addFlight(values);
    }

    @WebMethod(operationName = "changeFlight")
    public String changeFlight(String values) {
        return new DbMethods().changeFlight(values);
    }

    @WebMethod(operationName = "deleteFlight")
    public String deleteFlight(int arg) {
        return new DbMethods().deleteFlight(arg);
    }
}
