package recommendation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import csv.HotelScoredParser;
import data.HotelScored;
import data.ScoreType;

public class RecommendationGenerator {

    private static final String ALL_HOTELS_PATH = "./src/main/resources/hotels_scored.csv";
    private static final List<HotelScored> allHotels = HotelScoredParser.parseHotelReviewsCsv(ALL_HOTELS_PATH);

    public static List<HotelScored> getRecommendationsByScoreTypes(Set<ScoreType> scoreTypes) {
        Map<HotelScored, Integer> totalScoreCounter = new HashMap<>();
        List<HotelScored> hotelsScored = new ArrayList<>(allHotels);

        scoreTypes.forEach(scoreType -> {
            hotelsScored.sort(Comparator.comparingDouble(o -> o.getScore(scoreType)));
            for (int i = 0; i < hotelsScored.size(); i++) {
                HotelScored hotelScored = hotelsScored.get(i);
                int newScore = totalScoreCounter.getOrDefault(hotelScored, 0) + (hotelsScored.size() - i);
                totalScoreCounter.put(hotelScored, newScore);
            }
        });

        List<HotelScored> sortedHotels = totalScoreCounter.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
        if (sortedHotels.size() < 5) {
            return sortedHotels;
        }
        return sortedHotels.subList(0, 5);
    }
}
