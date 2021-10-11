package lessons;

import base.BaseTest;
import base.Role;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base.LogIn;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import java.io.File;

public class AddLesson_VerifyAddLesson_CorrectData_UsedAdminMentorRole extends BaseTest {

    LogIn logIn;
    LessonsPage lessons;
    AddLessonData data;

    @BeforeClass
    public void preconditions() throws Exception{
        driver.get(Endpoints.BASE_URL);
        logIn = new LogIn(driver);
        lessons = new LessonsPage(driver);
        data = helper.getMapper().readValue(
                new File(PathsToFiles.Lessons.ADD_LESSON_CORRECT_DATA), AddLessonData.class);
    }

    @DataProvider(name = "log-in")
    public Object[][] provideCredentials(){
        return new Object[][]{{Role.ADMIN, data}, {Role.MENTOR, data}};
    }

    @Test(dataProvider = "log-in")
    public void addLesson(Role role, AddLessonData data){

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        helper.logInAs(role);

        helper.waitForRedirectFrom(Endpoints.AUTH);
        driver.get(Endpoints.LESSONS);

        AddLessonPage addLessonPage = lessons.clickAddLessonButton();
        SoftAssert softAssert = new SoftAssert();
        addLessonPage.setSoftAssert(softAssert);
        addLessonPage.fillLessonTheme(data.getTheme(), null)
                .fillGroupName(data.getG_name(), null)
                .fillDateInput(data.getDate())
                .fillEmailInput(data.getEmail(), null)
                .clickClassRegisterButton()
                .clickSaveButton();
        helper.waitDownloadPage(Endpoints.LESSONS);
        helper.waitForVisibilityOfElement(lessons.getAlert());
        softAssert.assertEquals(lessons.getAlertText(), expectedResult);
        softAssert.assertAll();

        lessons.getHeader().logOut();
    }
}
