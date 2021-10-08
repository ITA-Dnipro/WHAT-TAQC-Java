package lessons;

import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import lessons.data.AddLessonData;
import lessons.data.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
        logIn.fillMail(user.getMail())
                .fillPass(user.getPass())
                .clickLogInButton();
        wait.until(url -> !(driver.getCurrentUrl().equals(Endpoints.AUTH)));
        driver.get(Endpoints.LESSONS);
        AddLessonPage addLessonPage = lessons.clickAddLessonButton();
        addLessonPage.fillLessonTheme(data.getTheme())
                .fillGroupName(data.getG_name())
                .fillDateInput(data.getDate())
                .fillEmailInput(data.getEmail())
                .clickClassRegisterButton()
                .clickSaveButton();
        wait.until(url -> driver.getCurrentUrl().equals(Endpoints.LESSONS));
        lessons.getHeader().logOut();
    }
}
