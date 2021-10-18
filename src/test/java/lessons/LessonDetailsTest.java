package lessons;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class LessonDetailsTest extends BaseTest {

    LessonsPage lessonsPage;

    @BeforeClass
    public void preconditions() throws IOException {

        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test
    public void checkButtons(){
        lessonsPage
                .clickTableItem(0).isAtPage(waitTime)
                .clickGroupNameLink().isAtPage(waitTime);
    }
}
