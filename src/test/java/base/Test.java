package base;


import constants.Endpoints;
import constants.PathsToFiles;
import data.AddLessonData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import page.StudentsPage;
import page.base.Auth;
import page.lessons.LessonsPage;
import util.Role;
import java.io.IOException;

public class Test extends BaseTest{

     protected LessonsPage lessonsPage;
     protected AddLessonData data;

    public Test() throws IOException {
        data = AddLessonData.getData(PathsToFiles.Lessons.ADD_LESSON_CORRECT_DATA);
    }

    @BeforeClass
    public void precondition() throws IOException {

        lessonsPage = Auth.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "addLesson")
    public Object[][] getData(){
        return new Object[][]{{data}};
    }

    @org.testng.annotations.Test(dataProvider = "addLesson")
    public void test(AddLessonData data) throws IOException {

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        String actualResult = lessonsPage
                .clickAddLessonButton().isAtPage(waitTime)
                .fillLessonTheme(data.getTheme())
                .fillGroupName(data.getG_name())
                .fillDateInput(data.getDate())
                .fillEmailInput(data.getEmail())
                .clickClassRegisterButton()
                .clickSaveButton()
                .isAtPage(waitTime)
                .getAlertText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
