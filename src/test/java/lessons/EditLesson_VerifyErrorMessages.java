package lessons;

import base.BaseTest;
import base.Role;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.EditLessonErrors;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;
import java.io.File;
import java.io.IOException;

public class EditLesson_VerifyErrorMessages extends BaseTest {

    private static final Logger logger =
            Logger.getLogger(EditLesson_VerifyErrorMessages.class.getName());

    LessonsPage lessons;
    EditLessonPage editLessonPage;
    EditLessonErrors[] data;

    @BeforeClass
    public void preconditions() throws IOException {
        lessons = new LessonsPage(driver);
        driver.get(Endpoints.BASE_URL);
        helper.logInAs(Role.ADMIN);
        data = helper.getMapper().readValue(
                new File(PathsToFiles.Lessons.EDIT_LESSON_ERRORS), EditLessonErrors[].class);
        driver.get(Endpoints.LESSONS);

        if (lessons.getEdit().size() != 0){
            editLessonPage = lessons.clickEditIcon(1);
        }
        else {
            logger.info("Test is blocked! User haven't got lessons");
            return;
        }
    }

    @DataProvider(name = "errors")
    public Object[][] getData(){
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++){
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(dataProvider = "errors")
    public void verifyErrors(EditLessonErrors errors) {

        SoftAssert softAssert = new SoftAssert();
        editLessonPage.setSoftAssert(softAssert);
        helper.waitForRedirectFrom(Endpoints.LESSONS);
        editLessonPage.fillLessonThemeInput(errors.getTheme(), errors.getResult())
                .fillTimeInput(errors.getDate())
                .clickSaveButton();
        softAssert.assertAll();
    }
}
