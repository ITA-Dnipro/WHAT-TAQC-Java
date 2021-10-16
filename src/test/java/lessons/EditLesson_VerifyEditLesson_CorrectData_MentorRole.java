package lessons;

import org.testng.annotations.BeforeClass;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import java.io.IOException;

public class EditLesson_VerifyEditLesson_CorrectData_MentorRole extends EditLesson_VerifyEditLesson_CorrectData_AdminRole{


    @BeforeClass
    @Override
    public void precondition() throws IOException {
        this.lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);

        if (!this.lessonsPage.isLessons()){
            this.lessonsPage = this.lessonsPage
                    .clickAddLessonButton()
                    .isAtPage(waitTime)
                    .addLessonForTest();
        }
    }
}
