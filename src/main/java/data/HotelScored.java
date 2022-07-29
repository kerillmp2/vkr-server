package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import csv.RawHotelScored;

public record HotelScored(
        String name,
        Map<ScoreType, Double> scores,
        String address,
        int numberOfReviews,
        String country,
        int id)
{
    public static HotelScored fromRawHotelScored(RawHotelScored rawHotelScored) {
        Map<ScoreType, Double> scores = new HashMap<>();
        scores.put(ScoreType.CLEAN, Double.parseDouble(rawHotelScored.getClean_score()));
        scores.put(ScoreType.LOCATION, Double.parseDouble(rawHotelScored.getLocation_score()));
        scores.put(ScoreType.SERVICE, Double.parseDouble(rawHotelScored.getService_score()));
        scores.put(ScoreType.ROOM, Double.parseDouble(rawHotelScored.getRoom_score()));
        scores.put(ScoreType.MONEY, Double.parseDouble(rawHotelScored.getMoney_score()));
        scores.put(ScoreType.FOOD, Double.parseDouble(rawHotelScored.getFood_score()));
        scores.put(ScoreType.TRANSPORT, Double.parseDouble(rawHotelScored.getTransport_score()));
        scores.put(ScoreType.FACILITIES, Double.parseDouble(rawHotelScored.getFacilities_score()));
        scores.put(ScoreType.CULTURE, Double.parseDouble(rawHotelScored.getCulture_score()));
        scores.put(ScoreType.JOY, Double.parseDouble(rawHotelScored.getJoy_score()));
        scores.put(ScoreType.OVERALL, Double.parseDouble(rawHotelScored.getAverage_Score()));
        return new HotelScored(
                rawHotelScored.getHotel_name(),
                scores,
                rawHotelScored.getHotel_Address(),
                Integer.parseInt(rawHotelScored.getTotal_Number_of_Reviews()),
                rawHotelScored.getCountry(),
                Integer.parseInt(rawHotelScored.getId())
        );
    }

    public double getScore(ScoreType scoreType) {
        return scores.getOrDefault(scoreType, 0d);
    }

    public String getView() {
        return this.name + " (Address: " + this.address + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelScored that = (HotelScored) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
