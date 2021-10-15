package base;


import constants.Endpoints;
import page.StudentsPage;
import page.base.Auth;
import util.Role;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test extends BaseTest{

    public Test() throws IOException {
    }

    @org.testng.annotations.Test
    public void test() throws IOException {
        driver.get(Endpoints.BASE_URL);
        Auth auth = new Auth(driver);
        auth.logInAs(Role.ADMIN, StudentsPage.class).isAt(10, TimeUnit.SECONDS);

    }
}
