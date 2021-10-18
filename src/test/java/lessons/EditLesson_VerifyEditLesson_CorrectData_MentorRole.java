package lessons;

import base.BaseTest;
import constants.PathsToFiles;
import lessons.util.AddLessonStrategy;
import lessons.util.ApiAddLessonStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditLesson_VerifyEditLesson_CorrectData_MentorRole extends BaseTest {

    AddLessonStrategy addLessonStrategy;
    LessonsPage lessonsPage;
    User user;
    String theme;
    Integer firstIcon;


    @BeforeClass
    public void precondition() throws Exception {
        user = User.get(PathsToFiles.CREDENTIALS).get(Role.MENTOR.getRoleName());
        addLessonStrategy = new ApiAddLessonStrategy();

        if (addLessonStrategy.addNewLesson(user)){
            log.info("Lesson was added with API!");
        }

        this.lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, user, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-44")
    public void editLessonTest() {

        String expectedResult = "×\nClose alert\nThe lesson has been edited successfully";

        lessonsPage
                .clickEditIcon(firstIcon)
                .isAtPage(waitTime)
                .fillLessonThemeInput(theme)
                .verifyThemeNameInputFieldIsFilled(theme)
                .fillTimeInput(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm")))
                .verifyDateInputFieldIsFilled()
                .verifyAll()
                .clickSaveButton()
                .isAtPage(waitTime)
                .verifyAlertMessageText(expectedResult);
    }
}
