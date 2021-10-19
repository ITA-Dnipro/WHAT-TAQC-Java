package lessons;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.lessons.LessonsPage;
import util.RandomStringsGenerator;
import util.Role;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddLessonPage_VerifyAddLesson_CorrectData_MentorRoleTest extends BaseTest {

    protected LessonsPage lessonsPage;
    String themeName;
    String date;

    @BeforeClass
    public void setUp() throws IOException {
        themeName = RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5);
        date = LocalDateTime.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm"));

        lessonsPage = AuthPage.init(driver).isAt()
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-62")
    public void verifyAddLesson() {
        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        lessonsPage
                .clickAddLessonButton().isAtPage(waitTime)
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
