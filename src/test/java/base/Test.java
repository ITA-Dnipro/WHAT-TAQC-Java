package base;


import constants.Endpoints;
import page.StudentsPage;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test extends BaseTest{

    @org.testng.annotations.Test
    public void test() throws IOException {
        driver.get(Endpoints.BASE_URL);
        Auth.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAt(10, TimeUnit.SECONDS)
                .getStudent()
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAt(10, TimeUnit.SECONDS)
                .clickAddLessonButton()
                .fillEmailInput("some text")
                .fillGroupName("some group")
                .clickClassRegisterButton();
    }
}
