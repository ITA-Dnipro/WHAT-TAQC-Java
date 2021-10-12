package constants;

public class PathsToFiles {

    private PathsToFiles() {}

    public static final String BASE_PATH = "./src/main/resources/";
    public static final String CREDENTIALS = BASE_PATH + "credentials/credentials.json";

    public interface Lessons {
        String ADD_LESSON_CORRECT_DATA = BASE_PATH + "lessons/AddLessonCorrectData.json";
        String ADD_LESSON_ERRORS = BASE_PATH + "lessons/AddLessonErrors.json";
    }
}
