package lessons;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonErrors;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.StudentsPage;
import page.base.Auth;
import page.lessons.AddLessonPage;
import util.Role;

import java.io.IOException;

public class AddLessonPage_VerifyErrorMessages extends BaseTest {

    AddLessonErrors[] errors;
    AddLessonPage addLessonPage;

    public AddLessonPage_VerifyErrorMessages() throws IOException {
        errors = AddLessonErrors.getErrors(PathsToFiles.Lessons.ADD_LESSON_ERRORS);
    }

    @BeforeClass
    public void preconditions() throws IOException {
        addLessonPage =
                Auth.init(driver).logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.ADD_LESSON, AddLessonPage.class)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "errors")
    public Object[][] provideErrors(){
        Object[][] list = new Object[errors.length][1];
        for (int i = 0; i < errors.length; i++){
            list[i][0] = errors[i];
        }
        return list;
    }

    @Test(description = "DP213-66", dataProvider = "errors")
    public void checkThemeErrors(AddLessonErrors errors){
        String expectedResult = errors.getTheme_result();

        String actualResult = addLessonPage
                        .fillLessonTheme(errors.getTheme())
                        .loseFocus()
                        .getThemeError();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "DP213-66", dataProvider = "errors")
    public void checkGroupErrors(AddLessonErrors errors){
        String expectedResult = errors.getG_name_result();

        String actualResult = addLessonPage
                .fillGroupName(errors.getG_name())
                .loseFocus()
                .getGroupError();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "DP213-66", dataProvider = "errors")
    public void checkMailErrors(AddLessonErrors errors){
        String expectedResult = errors.getEmail_result();

        String actualResult = addLessonPage
                .fillEmailInput(errors.getEmail_result())
                .loseFocus()
                .getMailError();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
