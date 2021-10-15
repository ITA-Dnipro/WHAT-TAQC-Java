package constants;

import org.openqa.selenium.WebDriver;
import page.StudentsPage;
import page.base.Page;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, Page> getPages(WebDriver driver){
        Map<String, Page> pages = new HashMap<>();
        pages.put(STUDENTS, new StudentsPage(driver));
        pages.put(LESSONS, new LessonsPage(driver));
        pages.put(EDIT_LESSON, new EditLessonPage(driver));
        return pages;
    }
}
