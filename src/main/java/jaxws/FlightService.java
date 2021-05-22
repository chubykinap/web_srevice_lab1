package jaxws;

import jaxws.exceptions.AuthException;
import jaxws.exceptions.MyFault;
import jaxws.exceptions.SQLTransactionException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "javaxp.FlightService")
public class FlightService {
    @Resource
    WebServiceContext context;

    @WebMethod(operationName = "getFlights")
    public List<Flight> getFlights(String arg) throws SQLTransactionException {
        return new DbMethods().getFlights(arg);
    }

    @WebMethod(operationName = "addFlight")
    public int addFlight(String values) throws SQLTransactionException, AuthException {
        authentication(context.getMessageContext());
        return new DbMethods().addFlight(values);
    }

    @WebMethod(operationName = "changeFlight")
    public String changeFlight(String values) throws SQLTransactionException, AuthException {
        authentication(context.getMessageContext());
        return new DbMethods().changeFlight(values);
    }

    @WebMethod(operationName = "deleteFlight")
    public String deleteFlight(int arg) throws SQLTransactionException, AuthException {
        authentication(context.getMessageContext());
        return new DbMethods().deleteFlight(arg);
    }

    private void authentication(MessageContext mctx) throws AuthException {
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        if (userList == null || passList == null) {
            throw new AuthException("Received null data", MyFault.defaultInstance());
        }

        if (!userList.get(0).equals("user") || !passList.get(0).equals("pass"))
            throw new AuthException("Authentication failed", MyFault.defaultInstance());
    }
}
