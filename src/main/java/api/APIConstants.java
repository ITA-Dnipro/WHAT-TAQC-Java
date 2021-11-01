package api;

import java.util.HashMap;
import java.util.Map;

public class APIConstants {
    public static final String BASE_LINK = "https://charliebackendapi.azurewebsites.net/api/v2";
    public static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final Map<String, String> HEADERS = new HashMap<>();
    public static final String EMPTY_STRING = "";
    public static final String STRING_WITH_SPECIAL_SYMBOLS = "#@)g&$0";

    static {
        HEADERS.put("Transfer-Encoding", "chunked");
        HEADERS.put("Content-Type", "application/json; charset=utf-8");
        HEADERS.put("Content-Encoding", "gzip");
        HEADERS.put("Vary", "Accept-Encoding");
        HEADERS.put("Server", "Microsoft-IIS/10.0");
        HEADERS.put("api-supported-versions", "1.0, 2.0");
        HEADERS.put("X-Powered-By", "ASP.NET");
    }

    public interface StatusCodes {
        Integer OK = 200;
        Integer UNAUTHORIZED = 401;
        Integer FORBIDDEN = 403;
        Integer ACCOUNT_NOT_FOUND = 404;
        Integer NO_RIGHTS = 409;
        Integer BAD_REQUEST = 400;
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
        String BAD_DATE_MESSAGE = "Lesson date is incorrect";
        String TOO_LONG_THEME_NAME_MESSAGE =
                "The length of 'Theme Name' must be 100 characters or fewer. You entered 101 characters.";
        String EMPTY_STUDENT_GROUP_MESSAGE = "'Student Group Id' must not be empty.";
        String EMPTY_MENTOR_ID_MESSAGE = "'Mentor Id' must not be empty.";
        String EMPTY_THEME_NAME_MESSAGE = "'Theme Name' must not be empty.";
        String BAD_THEME_NAME = "Incorrect 'Theme Name'";
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
