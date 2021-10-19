package constants;

import java.io.FileInputStream;
import java.util.Properties;

public class PathsToFiles {

    private PathsToFiles() {}

    public static final String BASE_PATH = "./src/main/resources/";
    public static final String CREDENTIALS = "D:\\WHAT\\DataForTest\\credentials.json";

    public interface Lessons {
        String ADD_LESSON_CORRECT_DATA = BASE_PATH + "lessons/AddLessonIncorrectData.json";
        String ADD_LESSON_ERRORS = BASE_PATH + "lessons/AddLessonErrors.json";
        String EDIT_LESSON_ERRORS = BASE_PATH + "lessons/EditLessonErrors.json";
        String ADD_NEW_LESSON = BASE_PATH + "lessons/lesson.json";
    }

    public interface ChangePassword {
        String CHANGE_PASSWORD_INVALID_DATA = BASE_PATH + "changePassword/ChangePassword_InvalidData.json";
        String CHANGE_PASSWORD_VALID_DATA = BASE_PATH;
    }

    public interface Courses {
        String ADD_COURSES_VALID_DATA = BASE_PATH + "courses/addCourses/AddCourses_ValidData.json";
        String EDIT_COURSES_INVALID_DATA = BASE_PATH + "courses/EditCourses/EditCourseDetails_InvalidData.json";
        String EDIT_COURSES_VALID_DATA = BASE_PATH + "courses/EditCourses/EditCourseDetails_ValidData.json";
        String SEARCH_COURSES_NAME = BASE_PATH + "courses/EditCourses/SearchField_ValidData.json";
        String EDIT_COURSES_MENTOR_STUDENT_ROLES = BASE_PATH + "courses/EditCourses/EditCourseDetails_ValidDataMentorStudent.json";
    }

    public interface Mentors{
        String EDIT_MENTOR_ERRORS=BASE_PATH + "mentors/InvalidData.json";
    }
}
