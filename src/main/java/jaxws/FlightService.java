package jaxws;

import jaxws.exceptions.SQLTransactionException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "javaxp.FlightService")
public class FlightService {
    @WebMethod(operationName = "getFlights")
    public List<Flight> getFlights(String arg) throws SQLTransactionException {
        return new DbMethods().getFlights(arg);
    }

    @WebMethod(operationName = "addFlight")
    public int addFlight(String values) throws SQLTransactionException {
        return new DbMethods().addFlight(values);
    }

    @WebMethod(operationName = "changeFlight")
    public String changeFlight(String values) throws SQLTransactionException {
        return new DbMethods().changeFlight(values);
    }

    @WebMethod(operationName = "deleteFlight")
    public String deleteFlight(int arg) throws SQLTransactionException {
        return new DbMethods().deleteFlight(arg);
    }
}
