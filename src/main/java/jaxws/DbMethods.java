package jaxws;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbMethods {

    public List<Flight> getFlights(String arg) {
        List<Flight> flights = new ArrayList<>();


        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(generateQuery(arg));

            while (rs.next()) {
                String flight_number = rs.getString("flight_number");
                Date departure_date = rs.getDate("departure_date");
                String departure_city = rs.getString("departure_city");
                String arrival_city = rs.getString("arrival_city");
                String aircraft_type = rs.getString("aircraft_type");

                flights.add(new Flight(flight_number, departure_date, departure_city,
                        arrival_city, aircraft_type));
            }
        } catch (SQLException e) {
            Logger.getLogger(DbMethods.class.getName()).log(Level.SEVERE, null, e);
        }
        return flights;
    }

    private String generateQuery(String arg){
        String[] args = arg.split(" ");

        StringBuilder request = new StringBuilder().append("select * from flights where ");
        for (int i = 0;i<args.length;i+=2) {
            request.append(args[i]).append(" = '").append(args[i + 1]).append("'");
            if (i < args.length - 2)
                request.append(" and ");
        }
        request.append(";");
        return request.toString();
    }
}
