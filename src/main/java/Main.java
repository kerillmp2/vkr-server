import java.io.IOException;

import server.Server;


public class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server(4004, 250);
        server.serve();

       /* final http_clients.AviasalesHttpClient httpClient = new http_clients.AviasalesHttpClient();

      System.out.println("https://api.travelpayouts.com/aviasales/v3/prices_for_dates?origin=MOW&destination=DXB&currency=usd&departure_at=2022-03-01&return_at=2022-03-10&sorting=price&direct=true&limit=10&token=2a8aef3ef72f45aa74a58a205661aa54");
        System.out.println(httpClient.sendGet(http_clients.AviasalesHttpClient.RequestTypes.PRICES_FOR_DATES, params));

        System.out.println(IataHttpClient.getAirportIATA("ижевск"));
        AviasalesAPIController aviasalesAPIController = new AviasalesAPIController();

        System.out.println(aviasalesAPIController.getLowestCostFlights(
                "СПБ",
                "Москва",
                "2022-05-22",
                ""
        ));
        System.out.println(aviasalesAPIController.getLowestCostFlights(
                "СПБ",
                "Москва",
                "2022-05-22",
                ""
        ));
        System.out.println(aviasalesAPIController.getLowestCostFlights(
                "СПБ",
                "Moscow",
                "2022-05-22",
                ""
        ));*/
    }
}
