package lessons;

import base.BaseTest;
import constants.PathsToFiles;
import lessons.util.AddLessonStrategy;
import lessons.util.ApiAddLessonStrategy;
import lessons.util.WebAddLessonStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditLessonPage_VerifyEditLesson_CorrectData_MentorRoleTest extends BaseTest {

    AddLessonStrategy addLessonStrategy;
    LessonsPage lessonsPage;
    User user;
    String theme;
    Integer firstIcon;


    @BeforeClass
    public void precondition() throws Exception {
        user = User.get(PathsToFiles.getCredentials()).get(Role.MENTOR.getRoleName());
        addLessonStrategy = new ApiAddLessonStrategy();
        firstIcon = 0;

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
                        .format(DateTimeFormatter.ofPattern(AddLessonPage.DATE_FORMAT)))
                .verifyDateInputFieldIsFilled()
                .verifyAll()
                .clickSaveButton()
                .isAtPage(waitTime)
                .verifyAlertMessageText(expectedResult);
    }
}
