package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.fluent.Content;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContentToDataParser {

    public static List<FlightData> parseFlightDataFromContent(Content content) {
        if (content.equals(Content.NO_CONTENT)) {
            return List.of();
        } else {
            List<FlightData> flightDatas = new ArrayList<>();
            JSONObject object = new JSONObject(content.asString());
            JSONArray data = object.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject flight = data.getJSONObject(i);
                FlightData flightData = new FlightData(
                        flight.getString("origin"),
                        flight.getString("destination"),
                        flight.getString("origin_airport"),
                        flight.getString("destination_airport"),
                        flight.getInt("price"),
                        "rub",
                        flight.getString("airline"),
                        flight.getString("flight_number"),
                        parseDate(flight.getString("departure_at")),
                        flight.getInt("transfers"),
                        flight.getInt("duration"),
                        flight.getString("link")
                );
                flightDatas.add(flightData);
            }
            return flightDatas;
        }
    }

    private static LocalDate parseDate(String s) {
        return LocalDate.parse(s.substring(0, "2000-01-01".length()));
    }
}
