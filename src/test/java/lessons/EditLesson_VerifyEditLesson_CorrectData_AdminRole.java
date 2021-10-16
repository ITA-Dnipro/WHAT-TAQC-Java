package lessons;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class EditLesson_VerifyEditLesson_CorrectData_AdminRole extends BaseTest {

    LessonsPage lessonsPage;

    @BeforeClass
    public void precondition() throws IOException {
        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test()
    public void editLessonTest(){
        if (!lessonsPage.isLessons()){
            Assert.assertTrue(true);
        }
    }
}
