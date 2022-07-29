package response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.FlightData;
import data.HotelScored;

public class ResponseBuilder {

    public static ResponseTemplate empty(ServerResponse.ResponseType responseType) {
        return new ResponseTemplate(responseType, new HashMap<>(), new HashMap<>());
    }

    public static ServerResponse buildResponseWithFlightData(FlightData flightData) {
        return ResponseBuilder.empty(ServerResponse.ResponseType.GET_TICKET)
                .withParam("origin", flightData.origin())
                .withParam("destination", flightData.destination())
                .withParam("origin_airport", flightData.originAirport())
                .withParam("destination_airport", flightData.destinationAirport())
                .withParam("price", flightData.price())
                .withParam("currency", flightData.currency())
                .withParam("airline", flightData.airline())
                .withParam("flight_number", flightData.flightNumber())
                .withParam("departure_at", flightData.departureAt().toString())
                .withParam("transfers", flightData.transfers())
                .withParam("duration", flightData.duration())
                .withParam("link", "https://aviasales.ru/" + flightData.link())
                .build();
    }

    public static ServerResponse buildResponseWithRecommendation(List<HotelScored> recommendations) {
        StringBuilder recommendationStringBuilder = new StringBuilder();
        recommendations.forEach(rec -> recommendationStringBuilder.append(rec.getView()).append("\n"));
        return ResponseBuilder.empty(ServerResponse.ResponseType.GET_RECOMMENDATION)
                .withParam("recommendation_string", recommendationStringBuilder.toString())
                .build();
    }

    public static ServerResponse buildResponseWithError(ServerResponse.ResponseType responseType, String errorMessage) {
        return ResponseBuilder.empty(responseType)
                .withParam("error_msg", errorMessage)
                .build();
    }

    public record ResponseTemplate(ServerResponse.ResponseType responseType, Map<String, String> stringParams,
                                   Map<String, Integer> intParams) {
        public ResponseTemplate withParam(String name, String value) {
            stringParams.put(name, value);
            return this;
        }

        public ResponseTemplate withParam(String name, int value) {
            intParams.put(name, value);
            return this;
        }

        public ServerResponse build() {
            return new ServerResponse(responseType, stringParams, intParams);
        }
    }
}