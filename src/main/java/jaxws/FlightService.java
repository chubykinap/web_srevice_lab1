package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "javaxp.FlightService")
public class FlightService {
    @WebMethod(operationName = "getFlights")
    public List<Flight> getFlights(String arg){
        return new DbMethods().getFlights(arg);
    }
}
