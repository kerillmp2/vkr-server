package data;

public enum ScoreType {
    CLEAN,
    LOCATION,
    SERVICE,
    ROOM,
    MONEY,
    FOOD,
    TRANSPORT,
    FACILITIES,
    CULTURE,
    JOY,
    OVERALL,
    UNKNOWN;

    public static ScoreType byName(String name) {
        try {
            return ScoreType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
