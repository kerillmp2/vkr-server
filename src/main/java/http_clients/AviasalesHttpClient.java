package http_clients;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.AviasalesAPIController;
import controllers.LogController;
import data.ContentToDataParser;
import data.FlightData;
import org.apache.http.client.fluent.Content;

public class AviasalesHttpClient extends HttpClient {

    public static final AviasalesHttpClient INSTANCE = new AviasalesHttpClient("2a8aef3ef72f45aa74a58a205661aa54");
    public static final String AVIASALES_HOST = "api.travelpayouts.com/aviasales";

    public final String token;

    private AviasalesHttpClient(String token) {
        super(HTTP, AVIASALES_HOST);
        this.token = token;
    }

    public static Content sendGet(RequestTypes requestType, Map<String, String> params) {
        params.put("token", INSTANCE.token);
        return INSTANCE.sendGetWithParams(requestType.path, params);
    }

    public static List<FlightData> getLowestCostFlightsFromAPI(AviasalesAPIController.RequestData requestData) {
        Map<String, String> params = new HashMap<>();
        if (requestData.destination().length() == 0 || requestData.origin().length() == 0) {
            LogController.error("Неверный формат для даты: " + requestData);
            return List.of();
        }

        params.put("origin", requestData.origin());
        params.put("destination", requestData.destination());
        params.put("departure_at", requestData.departureDate());
        params.put("currency", "rub");
        params.put("direct", "false");

        Content content = sendGet(AviasalesHttpClient.RequestTypes.PRICES_FOR_DATES, params);
        return ContentToDataParser.parseFlightDataFromContent(content);
    }

    public enum RequestTypes {
        // Возвращает самые дешевые авиабилеты за определённые даты, найденные пользователями Aviasales.ru за последние 48 часов.
        PRICES_FOR_DATES("/v3/prices_for_dates"),

        // Возвращает самые дешевые авиабилеты, сгруппированные по определённом признаку, найденные пользователями Aviasales.ru за последние 48 часов.
        GROUPED_PRICES("/v3/grouped_prices"),

        // Возвращает цены на авиабилеты за определённый период, найденные пользователями Aviasales.ru за последние 48 часов.
        PRICES_LATEST("/v2/prices/latest"),

        // Возвращает цены за каждый день месяца, сгруппированные по количеству пересадок.
        MONTH_MATRIX("/v2/prices/month-matrix"),

        // Возвращает цены на неделю, начиная с заданных дат.
        WEEK_MATRIX("/v2/prices/week-matrix"),

        // Возвращает цены на направления между ближайшими к заданным городам.
        NEAREST_PLACES_MATRIX("/v2/prices/nearest-places-matrix"),

        // Возвращает аномально низкие цены на авиабилеты по выбранным направлениям.
        SPECIAL_OFFERS("/v3/get_special_offers"),

        // Возвращает самые популярные направления из заданного города
        CITY_DIRECTIONS("/v1/city-directions"),
        ;

        private final String path;

        RequestTypes(String path) {
            this.path = path;
        }
    }
}
