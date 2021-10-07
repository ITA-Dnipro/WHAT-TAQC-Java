package constants;

public class Endpoints {

    private Endpoints() {}

    public static final String BASE_URL = "http://localhost:8080";
    public static final String LESSONS = BASE_URL + "/lessons";
    public static final String ADD_LESSON = LESSONS + "/add";
    public static final String AUTH = BASE_URL + "/auth";
}
