package http_clients;

import java.util.Map;

import controllers.LogController;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

abstract class HttpClient {
    protected static final String HTTP = "http";
    protected static final String HTTPS = "https";

    private final String scheme;
    private final String host;

    public HttpClient(String scheme, String host) {
        this.scheme = scheme;
        this.host = host;
    }

    protected Content sendGetWithParams(String path, Map<String, String> params) {
        UrlBuilder urlBuilder = new UrlBuilder(scheme, host + path);
        params.forEach(urlBuilder::addQueryParam);
        String url = urlBuilder.build();
        try {
            LogController.info("Отправляем запрос: '" + url + "'");
            return Request.Get(url).execute().returnContent();
        } catch (Exception e) {
            LogController.error("Ошибка при отправке запроса " + url + ": " + e.getMessage());
            return Content.NO_CONTENT;
        }
    }

    public static class UrlBuilder {
        private final StringBuilder urlBuilder;
        private int paramCounter = 0;

        private UrlBuilder(StringBuilder urlBuilder) {
            this.urlBuilder = urlBuilder;
        }

        public UrlBuilder(String scheme, String path) {
            this(new StringBuilder(scheme + "://" + path));
        }

        public void addQueryParam(String key, String value) {
            char separator = paramCounter > 0 ? '&' : '?';
            urlBuilder.append(separator).append(key).append("=").append(value);
            paramCounter++;
        }

        public String build() {
            return urlBuilder.toString();
        }
    }
}
