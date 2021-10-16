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

public class EditLesson_VerifyEditLesson_CorrectData_AdminRole extends BaseTest {

    protected LessonsPage lessonsPage;

    @BeforeClass
    public void precondition() throws IOException {

        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);

        if (!lessonsPage.isLessons()){
            lessonsPage = lessonsPage
                    .clickAddLessonButton()
                    .isAtPage(waitTime)
                    .addLessonForTest();
        }
    }

    @Test()
    public void editLessonTest(){

        String expectedResult = "×\nClose alert\nThe lesson has been edited successfully";

        String actualResult = lessonsPage
                .clickEditIcon(0)
                .isAtPage(waitTime)
                .fillLessonThemeInput(RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5))
                .fillTimeInput(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm")))
                .clickSaveButton()
                .isAtPage(waitTime)
                .getAlertText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
