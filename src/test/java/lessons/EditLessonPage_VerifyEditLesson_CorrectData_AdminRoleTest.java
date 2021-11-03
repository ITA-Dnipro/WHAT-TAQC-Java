package lessons;

import api.entities.lessons.Lesson;
import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.util.AddLessonStrategy;
import lessons.util.WebAddLessonStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditLessonPage_VerifyEditLesson_CorrectData_AdminRoleTest extends BaseTest {

    LessonsPage lessonsPage;
    AddLessonStrategy addLessonStrategy;
    User user;
    String theme;
    Integer firstIcon;

    public EditLessonPage_VerifyEditLesson_CorrectData_AdminRoleTest() throws IOException {
        theme = RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(Lesson.getRandomNumberFromRange(
                AddLessonPage.MIN_LENGTH_THEME, AddLessonPage.MAX_LENGTH_THEME));
        firstIcon = 0;

        user = User.get(PathsToFiles.getCredentials())
                .get(Role.MENTOR.getRoleName());
    }

    @BeforeClass
    public void precondition() throws Exception {
        addLessonStrategy = new WebAddLessonStrategy(driver);

        if (addLessonStrategy.addNewLesson(user)){
            log.info("Lesson was added with WEB-UI!");
        }

        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-44")
    public void editLessonTest(){

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
