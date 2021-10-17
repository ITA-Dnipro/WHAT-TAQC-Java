package lessons;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class AddLesson_VerifyAddLesson_CorrectData_MentorRole extends AddLesson_VerifyAddLesson_CorrectData_AdminRole {

    public AddLesson_VerifyAddLesson_CorrectData_MentorRole(){
    }

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
        log.info("Logged in as Mentor");
    }

    @Test(description = "DP213-62")
    @Override
    public void verifyAddLesson() throws IOException {
        super.verifyAddLesson();
    }
}
