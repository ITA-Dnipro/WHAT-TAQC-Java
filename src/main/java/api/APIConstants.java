package api;

import org.apache.http.conn.util.PublicSuffixList;

public class APIConstants {
    public static final String BASE_LINK = "https://charliebackendapi.azurewebsites.net/api/v2";

    public interface AccountEndpoints {
        String AUTH_ENDPOINT = BASE_LINK + "/accounts/auth";
        String CHANGE_PASSWORD = BASE_LINK + "/api/v2/accounts/password";
    }

    public interface Courses {
        String COURSES_ENDPOINT = BASE_LINK + "/courses";
    }

    public interface Headers {
        String APPLICATION_JSON = "application/json";
        String CONTENT_TYPE = "Content-Type";
        String HEADER_AUTHORIZATION = "Authorization";
    }
}
