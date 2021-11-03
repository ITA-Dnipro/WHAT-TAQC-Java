package lessons;

import api.entities.lessons.Lesson;
import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static constants.Endpoints.ADD_LESSON;

public class AddLessonPage_VerifyAddLesson_CorrectData_MentorRoleTest extends BaseTest {

    AddLessonPage addLessonPage;
    String themeName;
    String date;

    @BeforeClass
    public void setUp() throws IOException {
        themeName = RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(
                Lesson.getRandomNumberFromRange(AddLessonPage.MIN_LENGTH_THEME, AddLessonPage.MAX_LENGTH_THEME));
        date = LocalDateTime.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern(AddLessonPage.DATE_FORMAT));

        addLessonPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime)
                .redirectTo(ADD_LESSON, AddLessonPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-62")
    public void verifyAddLesson() {
        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        addLessonPage
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
