package controllers;

import java.util.List;

import data.FlightData;

public class AviasalesAPIController {
    public static List<FlightData> getLowestCostFlights(
            String origin,
            String destination,
            String departureDate)
    {
        String originIATA = IataController.getIATA(origin);
        String destinationIATA = IataController.getIATA(destination);
        return CacheController.flightDataCache.get(new RequestData(originIATA, destinationIATA, departureDate));
    }

    public record RequestData(String origin, String destination, String departureDate) {

    }
}
