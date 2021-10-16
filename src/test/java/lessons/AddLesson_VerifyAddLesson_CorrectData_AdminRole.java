package lessons;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddLesson_VerifyAddLesson_CorrectData_AdminRole extends BaseTest {

     protected LessonsPage lessonsPage;

    @BeforeClass
    public void precondition() throws IOException {
        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-62")
    public void test() throws IOException {

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        String actualResult = lessonsPage
                .clickAddLessonButton().isAtPage(this.waitTime)
                .fillLessonTheme(RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5))
                .selectExistedGroup()
                .fillDateInput(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm")))
                .selectExistedMentor()
                .clickClassRegisterButton()
                .clickSaveButton()
                .isAtPage(waitTime)
                .getAlertText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
