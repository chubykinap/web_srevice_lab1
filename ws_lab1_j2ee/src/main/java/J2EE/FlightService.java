package J2EE;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "FlightService")
public class FlightService {
    @Resource(lookup = "jdbc/web_services")
    private DataSource dataSource;

    @WebMethod(operationName = "getFlights")
    public List<Flight> getFlights(String arg){
        return new DbMethods(getConnection()).getFlights(arg);
    }

    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            Logger.getLogger(FlightService.class.getName()).log(Level.SEVERE, "hey", e);
        }
        return connection;
    }
}
