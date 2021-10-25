package api;

public class APIConstants {
    public static final String BASE_LINK = "https://charliebackendapi.azurewebsites.net/api/v2";

    public interface AccountEndpoints {
        String COURSES_ENDPOINT = BASE_LINK + "/courses";
        String AUTH_ENDPOINT = BASE_LINK + "/accounts/auth";
    }

    public interface Headers {
        String APPLICATION_JSON = "application/json";
        String CONTENT_TYPE = "Content-Type";
        String HEADER_AUTHORIZATION = "Authorization";
    }
}
