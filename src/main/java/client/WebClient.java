package client;

import client.generated.Flight;
import client.generated.FlightService;
import client.generated.JavaxpFlightService;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.util.*;

public class WebClient {
    public static void main(String[] args) {
        JavaxpFlightService service = new JavaxpFlightService();
        FlightService flightService = service.getFlightServicePort();

        System.out.println("Введите одну из команд:\r\ninsert, update, delete, get");
        String method = new Scanner(System.in).nextLine(), request, state;
        try {
            switch (method) {
                case "insert":
                    addAuthHeaders(flightService);
                    System.out.println("Команда добавления\r\n" +
                            "Для использования напишите значения через запятую в одинарных кавычках в порядке\r\n" +
                            "flight_number, departure_date, departure_city, arrival_city, aircraft_type");
                    request = new Scanner(System.in).nextLine();
                    int result = flightService.addFlight(request);
                    System.out.println("Id новой записи - " + result);
                    return;
                case "update":
                    addAuthHeaders(flightService);
                    System.out.println("Команда изменения\r\n" +
                            "Для использования напишите через пробел номер записи, поля для обновления (через запятую) " +
                            "и значения (через запятую) в порядке:\r\n" +
                            "flight_number,departure_date,departure_city,arrival_city,aircraft_type");
                    request = new Scanner(System.in).nextLine();
                    state = flightService.changeFlight(request);
                    System.out.println("Статус выполнения: " + state);
                    return;
                case "delete":
                    addAuthHeaders(flightService);
                    System.out.println("Команда удаления\r\n" +
                            "Введите номер записи для удаления");
                    request = new Scanner(System.in).nextLine();
                    int id = Integer.parseInt(request);
                    state = flightService.deleteFlight(id);
                    System.out.println("Статус выполнения: " + state);
                    return;
                case "get":
                    System.out.println("Команда запроса на получение списка\r\n" +
                            "Запишите через пробел поле для поиска и его значение");
                    request = new Scanner(System.in).nextLine();
                    List<Flight> flights = null;
                    try {
                        flights = flightService.getFlights(request);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    for (Flight flight : flights) {
                        System.out.println("Полет " + flight.getFlightNumber() +
                                " " + flight.getDepartureDate() +
                                " из " + flight.getDepartureCity() +
                                " в " + flight.getArrivalCity());
                    }
                    return;
                default:
                    System.out.println("Команда не найдена");
            }
        } catch (Exception e) {
            System.out.println("Сообщение об ошибке от сервиса:\r\n" + e.getMessage());
        }
    }

    private static void addAuthHeaders(FlightService service){
        Map<String, Object> auth = ((BindingProvider) service).getRequestContext();
        auth.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://0.0.0.0:8080/FlightsService?wsdl");

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("user"));
        headers.put("Password", Collections.singletonList("pass"));
        auth.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

    }
}
