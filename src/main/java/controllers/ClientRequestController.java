package controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.FlightData;
import data.HotelScored;
import data.ScoreType;
import request.ClientRequest;
import response.ResponseBuilder;
import response.ServerResponse;

public class ClientRequestController {

    public static ServerResponse executeClientRequest(ClientRequest clientRequest) {
        String clientName = clientRequest.getStringParam("client_name");
        switch (clientRequest.getRequestType()) {
            case GET_TICKET -> {
                String origin = clientRequest.getStringParam("origin");
                String destination = clientRequest.getStringParam("destination");
                String date = clientRequest.getStringParam("date");
                LogController.info("Получен запрос билета от клиента " + clientName + ": " +
                        "{ Откуда: " + origin + "; Куда: " + destination + "; Дата: " + date + " }");

                List<FlightData> tickets = AviasalesAPIController.getLowestCostFlights(origin, destination, date);
                if (tickets.size() > 0) {
                    FlightData flightData = tickets.get(0);
                    return ResponseBuilder.buildResponseWithFlightData(flightData);
                } else {
                    return ResponseBuilder.buildResponseWithError(ServerResponse.ResponseType.GET_TICKET, "No tickets for this data!");
                }
            } case GET_RECOMMENDATION -> {
                String scoreTypesParam = clientRequest.getStringParam("score_types");
                LogController.info("Получен запрос рекомендаций от клиента " + clientName + ": [ " + scoreTypesParam + " ]");
                String[] scoreTypesSplitted = scoreTypesParam.split(",");
                Set<ScoreType> scoreTypes = new HashSet<>();
                for (String typeName : scoreTypesSplitted) {
                    ScoreType scoreType = ScoreType.byName(typeName);
                    if (scoreType != ScoreType.UNKNOWN) {
                        scoreTypes.add(scoreType);
                    }
                }
                scoreTypes.add(ScoreType.OVERALL);
                List<HotelScored> recommendations = RecommendationController.getRecommendations(scoreTypes);
                return ResponseBuilder.buildResponseWithRecommendation(recommendations);
            }
        }
        return ResponseBuilder.empty(ServerResponse.ResponseType.UNKNOWN)
                .withParam("client_name", clientName)
                .withParam("error_msg", "Can't client command!")
                .build();
    }
}
