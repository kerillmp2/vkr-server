package data;

import java.time.LocalDate;

public record FlightData(
        String origin,
        String destination,
        String originAirport,
        String destinationAirport,
        int price,
        String currency,
        String airline,
        String flightNumber,
        LocalDate departureAt,
        int transfers,
        int duration,
        String link)
{
}
