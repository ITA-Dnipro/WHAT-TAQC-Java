package lessons;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.AddLessonErrors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import page.lessons.AddLessonPage;
import util.Role;
import java.io.IOException;

public class AddLessonPage_VerifyErrorMessagesTest extends BaseTest {

    AddLessonErrors[] errors;
    AddLessonPage addLessonPage;

    public AddLessonPage_VerifyErrorMessagesTest() throws IOException {
        errors = AddLessonErrors.getErrors(PathsToFiles.Lessons.ADD_LESSON_ERRORS);
    }

    @BeforeClass
    public void setUp() throws IOException {
        addLessonPage =
                AuthPage.init(driver).logInAs(Role.ADMIN, StudentsPage.class)
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
    public void verifyErrors(AddLessonErrors errors){

        addLessonPage
                .fillLessonTheme(errors.getTheme())
                .verifyThemeNameInputFieldIsFilled(errors.getTheme())
                .loseFocus()
                .verifyThemeNameError(errors.getThemeResult())
                .fillGroupName(errors.getGroupName())
                .verifyGroupNameInputFieldIsFilled(errors.getGroupName())
                .loseFocus()
                .verifyGroupNameError(errors.getGroupNameResult())
                .fillDateInput(errors.getDate())
                .verifyDateInputFieldIsFilled()
                .loseFocus()
                .fillEmailInput(errors.getEmail())
                .verifyMentorEmailInputFieldIsFilled(errors.getEmail())
                .loseFocus()
                .verifyMentorMailError(errors.getEmailResult())
                .verifyAll();
    }
}
