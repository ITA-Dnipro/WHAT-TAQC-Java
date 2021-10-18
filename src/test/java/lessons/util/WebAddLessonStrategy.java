package lessons.util;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;

public class WebAddLessonStrategy implements AddLessonStrategy{

    WebDriver driver;
    LessonsPage page;

    public WebAddLessonStrategy(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean addNewLesson(User user) throws Exception {
        int waitTime = 5;
        page = AuthPage.init(driver)
                  .logInAs(Role.ADMIN, StudentsPage.class)
                  .isAtPage(waitTime)
                  .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                  .isAtPage(waitTime)
                  .clickAddLessonButton()
                  .addLessonForTest(user)
                  .isAtPage(waitTime);
        boolean result = page.getAlertText() != null;
        page.logOut();

        return result;
    }
}
