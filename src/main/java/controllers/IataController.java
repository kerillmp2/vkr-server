package controllers;

public class IataController {

    public static String getIATA(String request) {
        return CacheController.loadingCacheIATA.get(request);
    }
}
