package J2EE;

import java.util.Date;

public class Flight {
    private String flight_number;
    private Date departure_date;
    private String departure_city;
    private String arrival_city;
    private String aircraft_type;

    public Flight() {
    }

    public Flight(String flight_number, Date departure_date, String departure_city,
                  String arrival_city, String aircraft_type) {
        this.flight_number = flight_number;
        this.departure_date = departure_date;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.aircraft_type = aircraft_type;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getAircraft_type() {
        return aircraft_type;
    }

    public void setAircraft_type(String aircraft_type) {
        this.aircraft_type = aircraft_type;
    }
}
