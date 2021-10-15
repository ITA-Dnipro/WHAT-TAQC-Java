package base;


import constants.Endpoints;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import page.StudentsPage;
import page.base.Auth;
import page.base.Page;
import page.lessons.LessonsPage;
import util.Role;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test extends BaseTest{

    @DataProvider(name = "creds")
    public Object[][] provideCreds(){
        return new Object[][]{{Role.ADMIN, StudentsPage.class}, {Role.MENTOR, LessonsPage.class}};
    }


    @org.testng.annotations.Test(dataProvider = "creds")
    public void test(Role role, Class<Page> defaultPage) throws IOException {
        driver.get(Endpoints.BASE_URL);
        Auth.init(driver)
                .logInAs(role, defaultPage);
    }

    @AfterMethod
    public void logOut(){

    }
}
