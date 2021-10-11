package lessons;

import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import lessons.data.AddLessonErrors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base.LogIn;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import java.io.File;
import java.io.IOException;

public class AddLesson_VerifyErrorMessages extends BaseTest {

    LogIn logIn;
    LessonsPage lessons;
    ObjectMapper mapper;
    Object[][] list;

    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        logIn = new LogIn(driver);
        lessons = new LessonsPage(driver);
        mapper = new ObjectMapper();
        AddLessonErrors[] data = mapper.readValue(
                new File("./src/main/resources/lessons/AddLessonErrors.json"), AddLessonErrors[].class);
        list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++){
            list[i][0] = data[i];
        }
        logIn.fillMail("james.smith@example.com")
                .fillPass("_JkcG9dB")
                .clickLogInButton();
    }

    @DataProvider(name = "errors")
    public Object[][] provideCredentials(){
        return list;
    }

    @Test(dataProvider = "errors")
    public void verifyErrors(AddLessonErrors errors){
        helper.waitForRedirectFrom(Endpoints.AUTH);
        driver.get(Endpoints.ADD_LESSON);

        SoftAssert softAssert = new SoftAssert();
        AddLessonPage addLessonPage = new AddLessonPage(driver);

        addLessonPage.setSoftAssert(softAssert);
        addLessonPage.fillLessonTheme(errors.getTheme(), errors.getTheme_result())
                .fillGroupName(errors.getG_name(), errors.getG_name_result())
                .fillEmailInput(errors.getEmail(), errors.getEmail_result())
                .clickClassRegisterButton();
        softAssert.assertAll();
    }
}
