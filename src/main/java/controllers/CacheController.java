package controllers;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import data.FlightData;
import data.HotelScored;
import data.ScoreType;
import http_clients.AviasalesHttpClient;
import http_clients.IataHttpClient;
import recommendation.RecommendationGenerator;

public class CacheController {
    public static final LoadingCache<AviasalesAPIController.RequestData, List<FlightData>> flightDataCache = Caffeine.newBuilder()
            .maximumSize(864000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(AviasalesHttpClient::getLowestCostFlightsFromAPI);

    public static final LoadingCache<String, String> loadingCacheIATA = Caffeine.newBuilder()
            .maximumSize(70304)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(IataHttpClient::getAnyIATA);

    public static final LoadingCache<Set<ScoreType>, List<HotelScored>> recommendationCache = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build(RecommendationGenerator::getRecommendationsByScoreTypes);
}
