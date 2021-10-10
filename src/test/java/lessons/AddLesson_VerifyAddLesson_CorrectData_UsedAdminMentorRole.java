package lessons;

import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import lessons.data.AddLessonData;
import lessons.data.User;
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
    ObjectMapper mapper = new ObjectMapper();
    User[] userList;
    AddLessonData data;

    @BeforeClass
    public void preconditions() throws Exception{
        driver.get(Endpoints.BASE_URL);
        logIn = new LogIn(driver);
        lessons = new LessonsPage(driver);
        userList = mapper.readValue(
                new File("./src/main/resources/credentials.json"), User[].class);
        data = mapper.readValue(
                new File("./src/main/resources/lessons/AddLessonCorrectData.json"), AddLessonData.class);
    }

    @DataProvider(name = "log-in")
    public Object[][] provideCredentials(){
        return new Object[][]{{userList[0], data}, {userList[1], data}};
    }

    @Test(dataProvider = "log-in")
    public void addLesson(User user, AddLessonData data){

        String expectedResult = "×\nClose alert\nThe lesson has been added successfully!";

        logIn.fillMail(user.getMail())
                .fillPass(user.getPass())
                .clickLogInButton();

        helper.waitForRedirect(Endpoints.AUTH);
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
