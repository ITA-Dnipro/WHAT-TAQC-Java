package lessons;

import lessons.util.AddLessonStrategy;
import lessons.util.ApiAddLessonStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import java.io.IOException;

public class EditLesson_VerifyEditLesson_CorrectData_MentorRole extends EditLesson_VerifyEditLesson_CorrectData_AdminRole{

    AddLessonStrategy addLessonStrategy;

    public EditLesson_VerifyEditLesson_CorrectData_MentorRole() throws IOException {
    }

    @BeforeClass
    @Override
    public void precondition() throws Exception {

        addLessonStrategy = new ApiAddLessonStrategy();
        if (addLessonStrategy.addNewLesson(user)){
            log.info("Lesson was added with API!");
        }

        this.lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-44")
    @Override
    public void editLessonTest() {
        super.editLessonTest();
    }
}
