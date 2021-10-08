package lessons;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.lessons.LessonsPage;

public class AddLesson_VerifyErrorMessages extends BaseTest {

    LogIn logIn;
    LessonsPage lessons;

    @BeforeClass
    public void preconditions() {
        driver.get(Endpoints.BASE_URL);
        logIn = new LogIn(driver);
        lessons = new LessonsPage(driver);
    }

    @Test
    public void verifyErrors(){

    }

}
