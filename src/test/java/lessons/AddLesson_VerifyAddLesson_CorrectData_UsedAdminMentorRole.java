package lessons;

import base.BaseTest;
import base.Role;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonData;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import java.io.File;

public class AddLesson_VerifyAddLesson_CorrectData_UsedAdminMentorRole extends BaseTest {

    private static final Logger logger =
            Logger.getLogger(AddLesson_VerifyAddLesson_CorrectData_UsedAdminMentorRole.class.getName());

    LessonsPage lessons;
    AddLessonData data;

    @BeforeClass
    public void preconditions() throws Exception{
        driver.get(Endpoints.BASE_URL);
        logger.info(driver.getCurrentUrl());
        lessons = new LessonsPage(driver);
        data = helper.getMapper().readValue(
                new File(PathsToFiles.Lessons.ADD_LESSON_CORRECT_DATA), AddLessonData.class);
        logger.info("Data was read!");
    }

    @DataProvider(name = "log-in")
    public Object[][] provideCredentials(){
        return new Object[][]{{Role.ADMIN, data}, {Role.MENTOR, data}};
    }

    @Test(dataProvider = "log-in")
    public void addLesson(Role role, AddLessonData data){

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        helper.logInAs(role);
        logger.info(driver.getCurrentUrl());

        driver.get(Endpoints.LESSONS);
        logger.info(driver.getCurrentUrl());

        AddLessonPage addLessonPage = lessons.clickAddLessonButton();
        logger.info(driver.getCurrentUrl());

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
        logger.info("Log out!");
    }
}
