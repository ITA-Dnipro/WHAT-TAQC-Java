package constants;

import org.openqa.selenium.WebDriver;
import page.students.StudentsPage;
import page.base.Page;
import page.lessons.AddLessonPage;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;
import page.mentors.EditMentorsDetailsPage;
import page.mentors.MentorsTablePage;
import page.unassigned.UnassignedUsersPage;
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
    public static final String MENTORS=BASE_URL+"/mentors";
    public static final String EDIT_MENTORS=MENTORS+"/edit";

    public static Map<String, Page> getPages(WebDriver driver){
        Map<String, Page> pages = new HashMap<>();
        pages.put(STUDENTS, new StudentsPage(driver));
        pages.put(LESSONS, new LessonsPage(driver));
        pages.put(EDIT_LESSON, new EditLessonPage(driver));
        pages.put(ADD_LESSON, new AddLessonPage(driver));
        pages.put(UNASSIGNED_USERS,new UnassignedUsersPage(driver));
        pages.put(MENTORS,new MentorsTablePage(driver));
        pages.put(EDIT_MENTORS,new EditMentorsDetailsPage(driver));
        return pages;
    }
}
