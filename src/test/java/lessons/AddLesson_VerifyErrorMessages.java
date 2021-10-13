package lessons;

import base.BaseTest;
import base.Role;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonErrors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.lessons.AddLessonPage;
import java.io.File;
import java.io.IOException;

public class AddLesson_VerifyErrorMessages extends BaseTest {

    Object[][] list;
    AddLessonErrors[] data;

    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        data = helper.getMapper().readValue(
                new File(PathsToFiles.Lessons.ADD_LESSON_ERRORS), AddLessonErrors[].class);
        list = new Object[data.length][1];
        helper.logInAs(Role.ADMIN);
    }

    @DataProvider(name = "errors")
    public Object[][] provideCredentials(){
        for (int i = 0; i < data.length; i++){
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(dataProvider = "errors")
    public void verifyErrors(AddLessonErrors errors){
        driver.get(Endpoints.ADD_LESSON);

        SoftAssert softAssert = new SoftAssert();
        AddLessonPage addLessonPage = new AddLessonPage(driver);

        addLessonPage.setSoftAssert(softAssert);
        addLessonPage.fillLessonTheme(errors.getTheme(), errors.getTheme_result())
                .fillGroupName(errors.getG_name(), errors.getG_name_result())
                .fillEmailInput(errors.getEmail(), errors.getEmail_result());

        softAssert.assertAll();
    }
}
