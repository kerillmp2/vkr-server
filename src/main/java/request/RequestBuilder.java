package request;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    public static RequestTemplate empty(ClientRequest.RequestType requestType) {
        return new RequestTemplate(requestType, new HashMap<>(), new HashMap<>());
    }

    public record RequestTemplate(ClientRequest.RequestType requestType, Map<String, String> stringParams, Map<String, Integer> intParams) {
        public RequestTemplate withParam(String name, String value) {
            stringParams.put(name, value);
            return this;
        }

        public RequestTemplate withParam(String name, int value) {
            intParams.put(name, value);
            return this;
        }

        public ClientRequest build() {
            return new ClientRequest(requestType, stringParams, intParams);
        }
    }
}