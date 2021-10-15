package base;

import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;

import java.io.IOException;

public class TestChild extends Test{

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        driver.get(Endpoints.BASE_URL);
        lessonsPage = Auth.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAt(waitTime);
    }

    @org.testng.annotations.Test
    @Override
    public void test() throws IOException {
        super.test();
    }
}
