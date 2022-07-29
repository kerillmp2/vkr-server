package http_clients;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.fluent.Content;
import org.json.JSONArray;
import org.json.JSONObject;

public class IataHttpClient extends HttpClient {
    private static final IataHttpClient INSTANCE = new IataHttpClient();
    private static final String AUTOCOMPLETE_HOST = "autocomplete.travelpayouts.com";
    private static final String PATH = "/places2";

    private IataHttpClient() {
        super(HTTP, AUTOCOMPLETE_HOST);
    }

    public static String getAnyIATA(String request) {
        return getIATA(request, "city", "country", "airport");
    }

    public static String getCityIATA(String request) {
        return getIATA(request, "city");
    }

    public static String getCountryIATA(String request) {
        return getIATA(request, "country");
    }

    public static String getAirportIATA(String request) {
        return getIATA(request, "airport");
    }

    private static String getIATA(String request, String... types) {
        Map<String, String> params = new HashMap<>();
        params.put("term", request.replace(" ", ""));
        params.put("locale", "ru");
        params.put("types", String.join(",", types));
        Content resultContent = INSTANCE.sendGetWithParams(PATH, params);
        if (resultContent.equals(Content.NO_CONTENT)) {
            return "";
        } else {
            JSONArray resultArray = new JSONArray(resultContent.asString());
            if (resultArray.length() > 0) {
                JSONObject jsonObject = resultArray.getJSONObject(0);
                return jsonObject.getString("code");
            } else {
                return "";
            }
        }
    }
}
