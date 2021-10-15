package base;


import constants.Endpoints;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import page.StudentsPage;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class Test extends BaseTest{

     protected LessonsPage lessonsPage;

    @BeforeClass
    public void precondition() throws IOException {
        driver.get(Endpoints.BASE_URL);
        lessonsPage = Auth.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class).isAt(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class).isAt(waitTime);
    }

    @DataProvider(name = "addLesson")
    public Object[][] getData(){
        return new Object[][]{};
    }

    @org.testng.annotations.Test(dataProvider = "addLesson")
    public void test() throws IOException {
        lessonsPage
                .clickAddLessonButton().isAt(waitTime)
                .clickCancelButton().isAt(waitTime)
                .clickAddLessonButton().isAt(waitTime)
                .logOut();
    }
}
