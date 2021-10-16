package lessons;

import lessons.data.AddLessonData;
import org.testng.annotations.BeforeClass;
import page.unauthorizedUserPages.AuthPage;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class AddLesson_VerifyAddLesson_CorrectData_MentorRole extends AddLesson_VerifyAddLesson_CorrectData_AdminRole {

    public AddLesson_VerifyAddLesson_CorrectData_MentorRole() throws IOException {
    }

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @org.testng.annotations.Test(description = "DP213-62", dataProvider = "addLesson", priority = 1,
            dataProviderClass = AddLesson_VerifyAddLesson_CorrectData_AdminRole.class)
    @Override
    public void test(AddLessonData data) throws IOException {
        super.test(data);
    }
}
