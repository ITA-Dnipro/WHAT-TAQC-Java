package api;

import java.util.HashMap;
import java.util.Map;

public class APIConstants {
    public static final String BASE_LINK = "https://charliebackendapi.azurewebsites.net/api/v2";
    public static final String dateFormatForGroup = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final Map<String, String> HEADERS = new HashMap<>();

    static {
        HEADERS.put("Transfer-Encoding", "chunked");
        HEADERS.put("Content-Type", "application/json; charset=utf-8");
        HEADERS.put("Content-Encoding", "gzip");
        HEADERS.put("Vary", "Accept-Encoding");
        HEADERS.put("Server", "Microsoft-IIS/10.0");
        HEADERS.put("api-supported-versions", "1.0, 2.0");
        HEADERS.put("X-Powered-By", "ASP.NET");
    }

    public interface AccountEndpoints {
        String AUTH_ENDPOINT = "/accounts/auth";
        String CHANGE_PASSWORD = "/api/v2/accounts/password";
        String REGISTRATION = "/accounts/reg";
        String GET_ALL_REGISTERED_USERS = "/accounts";
    }

    public interface Courses {
        String COURSES_ENDPOINT = "/courses";
    }

    public interface Lessons {
        String LESSONS = "/lessons/";
        String ADD_LESSON = LESSONS + "add";
    }

    public interface StudentGroups {
        String STUDENT_GROUPS = "/student_groups/";
    }

    public interface Headers {
        String APPLICATION_JSON = "application/json";
        String CONTENT_TYPE = "Content-Type";
        String AUTHORIZATION = "Authorization";
        String ENCODING_UTF8 = "charset=utf-8";
    }

    public interface Mentors {
        String MENTORS = "/mentors/";
        String ACTIVE_MENTORS = MENTORS + "active/";
        String GROUPS = "/groups/";
    }

    public interface Student {
        String STUDENT = "/students/";
    }
}
