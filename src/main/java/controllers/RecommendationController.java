package controllers;

import java.util.List;
import java.util.Set;

import data.HotelScored;
import data.ScoreType;

public class RecommendationController {

    public static List<HotelScored> getRecommendations(Set<ScoreType> scoreTypes) {
        return CacheController.recommendationCache.get(scoreTypes);
    }
}
