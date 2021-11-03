package lessons;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.lessons.AddLessonPage;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import java.io.IOException;


public class AddLessonPage_VerifyAddLesson_IncorrectData_AdminRoleTest extends BaseTest{

    AddLessonData[] data;
    AddLessonPage addLessonPage;

    public AddLessonPage_VerifyAddLesson_IncorrectData_AdminRoleTest() throws IOException {
        data = AddLessonData.getData(PathsToFiles.Lessons.ADD_LESSON_INCORRECT_DATA);
    }

    @BeforeClass
    public void setUp() throws IOException {
        addLessonPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime)
                .clickAddLessonButton()
                .isAtPage(this.waitTime)
                .selectExistedGroup()
                .clickClassRegisterButton()
                .isAtPage(waitTime);
    }

    @DataProvider(name = "errors")
    public Object[][] provideErrors(){
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++){
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(description = "DP213-186", dataProvider = "errors")
    public void verifyAddLessonIncorrectData(AddLessonData addLessonData){

        addLessonPage
                .fillLessonTheme(addLessonData.getTheme())
                .fillGroupName(addLessonData.getGroupName())
                .fillDateInput(addLessonData.getDate())
                .fillEmailInput(addLessonData.getEmail())
                .clickSaveButton()
                .isAtPage(waitTime);
    }
}
