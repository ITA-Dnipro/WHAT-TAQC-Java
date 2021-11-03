package lessons;

import api.entities.lessons.Lesson;
import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddLessonPage_VerifyAddLesson_CorrectData_AdminRoleTest extends BaseTest {

     AddLessonPage addLessonsPage;
     String themeName;
     String date;

    @BeforeClass
    public void setUp() throws IOException {
        themeName = RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(
                Lesson.getRandomNumberFromRange(AddLessonPage.MIN_LENGTH_THEME, AddLessonPage.MAX_LENGTH_THEME));
        date = LocalDateTime.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern(AddLessonPage.DATE_FORMAT));

        addLessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime)
                .clickAddLessonButton()
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-62")
    public void verifyAddLesson() {

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

       addLessonsPage
                .fillLessonTheme(themeName)
                .verifyThemeNameInputFieldIsFilled(themeName)
                .selectExistedGroup()
                .verifyGroupNameInputFieldIsFilled()
                .fillDateInput(date)
                .verifyDateInputFieldIsFilled()
                .selectExistedMentor()
                .verifyMentorEmailInputFieldIsFilled()
                .verifyAll()
                .clickClassRegisterButton()
                .clickSaveButton()
                .isAtPage(waitTime)
                .verifyAlertMessageText(expectedResult);
    }
}
