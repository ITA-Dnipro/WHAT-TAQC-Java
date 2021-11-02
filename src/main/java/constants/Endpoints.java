package constants;

import org.openqa.selenium.WebDriver;
import page.base.Page;
import page.changePassword.ChangePasswordPage;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;
import page.lessons.AddLessonPage;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;
import page.mentors.EditMentorsDetailsPage;
import page.mentors.MentorsTablePage;
import page.myProfile.MyProfilePage;
import page.secretarys.SecretarysEditDetailsPage;
import page.secretarys.SecretarysPage;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;

import java.util.HashMap;
import java.util.Map;

public class Endpoints {

    private Endpoints() {
    }

    public static final String BASE_URL;

    static {
        if(System.getProperty("urlUI") != null){
            if(System.getProperty("portUrlUI") != null)
                BASE_URL = System.getProperty("urlUI") + System.getProperty("portUrlUI");
            else {
                BASE_URL = System.getProperty("urlUI") + PathsToFiles.getProperty("portUrlUI");
            }
        }
        else {
            if(System.getProperty("portUrlUI") != null)
                BASE_URL = PathsToFiles.getProperty("urlUI") + System.getProperty("portUrlUI");
            else {
                BASE_URL = PathsToFiles.getProperty("urlUI") + PathsToFiles.getProperty("portUrlUI");
            }
        }
    }


    public static final String LESSONS = BASE_URL + "/lessons";
    public static final String ADD_LESSON = LESSONS + "/add";
    public static final String AUTH = BASE_URL + "/auth";
    public static final String EDIT_LESSON = LESSONS + "/edit/";
    public static final String REGISTRATION = BASE_URL + "/registration";
    public static final String UNASSIGNED_USERS = BASE_URL + "/unassigned";
    public static final String STUDENTS = BASE_URL + "/students";
    public static final String MENTORS = BASE_URL + "/mentors";
    public static final String EDIT_MENTORS = MENTORS + "/edit";
    public static final String CHANGE_PASSWORD = BASE_URL + "/change-password";
    public static final String COURSES = BASE_URL + "/courses";
    public static final String ADD_COURSE = COURSES + "/add";
    public static final String MY_PROFILE = BASE_URL + "/my-profile";
    public static final String SECRETARY = BASE_URL+ "/secretaries";
    public static final String SECRETARY_EDIT= BASE_URL+"/secretaries/";



    public static Map<String, Page> getPages(WebDriver driver) {
        Map<String, Page> pages = new HashMap<>();
        pages.put(STUDENTS, new StudentsPage(driver));
        pages.put(LESSONS, new LessonsPage(driver));
        pages.put(EDIT_LESSON, new EditLessonPage(driver));
        pages.put(ADD_LESSON, new AddLessonPage(driver));
        pages.put(UNASSIGNED_USERS, new UnassignedUsersPage(driver));
        pages.put(MENTORS, new MentorsTablePage(driver));
        pages.put(EDIT_MENTORS, new EditMentorsDetailsPage(driver));
        pages.put(CHANGE_PASSWORD, new ChangePasswordPage(driver));
        pages.put(COURSES, new CoursesPage(driver));
        pages.put(ADD_COURSE, new AddCoursePage(driver));
        pages.put(MY_PROFILE, new MyProfilePage(driver));
        pages.put(SECRETARY, new SecretarysPage(driver));
        pages.put(SECRETARY_EDIT, new SecretarysEditDetailsPage(driver));
        return pages;
    }
}
