package lessons;

import base.BaseTest;
import base.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.lessons.LessonsPage;

public class EditLesson_VerifyErrorMessages extends BaseTest {

    LogIn logIn;
    LessonsPage lessons;
    ObjectMapper mapper;
    Object[][] list;

    @BeforeClass
    public void preconditions(){
        driver.get(Endpoints.BASE_URL);
        logIn = new LogIn(driver);
        lessons = new LessonsPage(driver);
        helper.logInAs(Role.ADMIN);
    }

    @Test
    public void verifyErrors() {
        helper.waitForRedirectFrom(Endpoints.AUTH);
        driver.get(Endpoints.LESSONS);
    }
}
