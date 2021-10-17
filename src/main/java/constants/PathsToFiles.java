package constants;

public class PathsToFiles {

    private PathsToFiles() {}

    public static final String BASE_PATH = "./src/main/resources/";
    public static final String CREDENTIALS = BASE_PATH + "credentials/credentials.json";

    public interface Lessons {
        String ADD_LESSON_CORRECT_DATA = BASE_PATH + "lessons/AddLessonIncorrectData.json";
        String ADD_LESSON_ERRORS = BASE_PATH + "lessons/AddLessonErrors.json";
        String EDIT_LESSON_ERRORS = BASE_PATH + "lessons/EditLessonErrors.json";
    }

    public interface ChangePassword {
        String CHANGE_PASSWORD_INVALID_DATA = BASE_PATH + "changePassword/ChangePassword_InvalidData.json";
        String CHANGE_PASSWORD_VALID_DATA = BASE_PATH + "changePassword/ChangePasswordWithPasswords.json";
    }

    public interface Сourses {
        String ADD_COURSES_VALID_DATA = BASE_PATH + "courses/addCourses/AddCourses_ValidData.json";
        String EDIT_COURSES_INVALID_DATA = BASE_PATH + "courses/EditCourses/EditCourseDetails_InvalidData.json";
        String EDIT_COURSES_VALID_DATA = BASE_PATH + "courses/EditCourses/EditCourseDetails_ValidData.json";
        String SEARCH_COURSES_NAME = BASE_PATH + "courses/EditCourses/SearchField_ValidData.json";
    }

    public interface Mentors{
        String EDIT_MENTOR_ERRORS=BASE_PATH + "mentors/InvalidData.json";
    }
}
