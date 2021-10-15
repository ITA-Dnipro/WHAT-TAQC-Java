package base;

import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.StudentsPage;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;

import java.io.IOException;

public class LessonDetailsTest extends BaseTest{

    LessonsPage lessonsPage;

    @BeforeClass
    public void preconditions() throws IOException {

        lessonsPage = Auth.init(driver)
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
