package constants;

public class Endpoints {

    private Endpoints() {}

    public static final String BASE_URL = "http://localhost:8080";
    public static final String LESSONS = BASE_URL + "/lessons";
    public static final String ADD_LESSON = LESSONS + "/add";
    public static final String AUTH = BASE_URL + "/auth";
    public static final String EDIT_LESSON = LESSONS + "/edit/";
    public static final String REGISTRATION = BASE_URL + "/registration";
    public static final String UNASSIGNED_USERS = BASE_URL + "/unassigned";
    public static final String STUDENTS = BASE_URL + "/students";
    public static final String COURSES = BASE_URL + "/courses";
}
