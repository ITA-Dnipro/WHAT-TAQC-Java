package base;

import constants.Endpoints;
import data.AddLessonData;
import org.testng.annotations.BeforeClass;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class AddLesson_VerifyAddLesson_CorrectData_MentorRole extends AddLesson_VerifyAddLesson_CorrectData_AdminRole {

    public AddLesson_VerifyAddLesson_CorrectData_MentorRole() throws IOException {
    }

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        driver.get(Endpoints.BASE_URL);
        lessonsPage = Auth.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @org.testng.annotations.Test(description = "DP213-62",
            dataProvider = "addLesson",
            dataProviderClass = AddLesson_VerifyAddLesson_CorrectData_AdminRole.class)
    @Override
    public void test(AddLessonData data) throws IOException {
        super.test(data);
    }
}
