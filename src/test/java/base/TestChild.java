package base;

import constants.Endpoints;
import data.AddLessonData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;

import java.io.IOException;

public class TestChild extends Test{

    public TestChild() throws IOException {
    }

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        driver.get(Endpoints.BASE_URL);
        lessonsPage = Auth.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @org.testng.annotations.Test(dataProvider = "addLesson", dataProviderClass = Test.class)
    @Override
    public void test(AddLessonData data) throws IOException {
        super.test(data);
    }
}
