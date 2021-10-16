package lessons;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import java.io.IOException;

public class AddLesson_VerifyAddLesson_CorrectData_AdminRole extends BaseTest {

     protected LessonsPage lessonsPage;
     protected AddLessonData data;

    public AddLesson_VerifyAddLesson_CorrectData_AdminRole() throws IOException {
        data = AddLessonData.getData(PathsToFiles.Lessons.ADD_LESSON_CORRECT_DATA);
    }

    @BeforeClass
    public void precondition() throws IOException {
        lessonsPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "addLesson")
    public Object[][] getData(){
        return new Object[][]{{data}};
    }

    @Test(description = "DP213-62", dataProvider = "addLesson", priority = 1)
    public void test(AddLessonData data) throws IOException {

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        String actualResult = lessonsPage
                .clickAddLessonButton().isAtPage(this.waitTime)
                .fillLessonTheme(RandomStringsGenerator.getAlphabeticStringLowerCaseCharacters(5))
                .selectExistedGroup()
                .fillDateInput("0303202000:00")
                .selectExistedMentor()
                .clickClassRegisterButton()
                .clickSaveButton()
                .isAtPage(waitTime)
                .getAlertText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
