package api;

public class APIConstants {
    public static final String BASE_LINK = "https://charliebackendapi.azurewebsites.net/api/v2";
    public static final String dateFormatForGroup = "yyyy-MM-dd HH:mm:ss.SSS";

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

    public interface StudentGroups{
        String STUDENT_GROUPS = "/student_groups/";
    }

    public interface Headers {
        String APPLICATION_JSON = "application/json";
        String CONTENT_TYPE = "Content-Type";
        String AUTHORIZATION = "Authorization";
        String ENCODING_UTF8 = "charset=utf-8";
    }
    public interface Mentors{
        String MENTORS="/mentors/";
        String ACTIVE_MENTORS=MENTORS+"active/";
    }
    public interface Student{
        String STUDENT="/student/";
    }
}
