package lessons;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.EditLessonError;
import lessons.util.AddLessonStrategy;
import lessons.util.ApiAddLessonStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.lessons.EditLessonPage;
import page.lessons.LessonsPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditLessonPage_VerifyErrorMessagesTest extends BaseTest {

    EditLessonError[] errors;
    EditLessonPage editLessonPage;
    AddLessonStrategy addLessonStrategy;
    User user;
    Integer firstIcon;

    public EditLessonPage_VerifyErrorMessagesTest() throws IOException {
        errors = EditLessonError.getErrors(PathsToFiles.Lessons.EDIT_LESSON_ERRORS);
        user = User.get(PathsToFiles.getPathToCredentials()).get(Role.ADMIN.getRoleName());
        firstIcon = 0;
    }

    @BeforeClass
    public void setUp() throws Exception {

        addLessonStrategy = new ApiAddLessonStrategy();
        if (addLessonStrategy.addNewLesson(user)){
            log.info("Lesson was added with API!");
        }

        editLessonPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.LESSONS, LessonsPage.class)
                .isAtPage(waitTime)
                .clickEditIcon(firstIcon)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "editLessonErrors")
    public Object[][] provideErrors(){
        Object[][] list = new Object[errors.length][1];
        for (int i = 0; i < errors.length; i++){
            list[i][0] = errors[i];
        }
        return list;
    }

    @Test(description = "DP213-153", dataProvider = "editLessonErrors")
    public void verifyInputFieldsErrors(EditLessonError error) {

        editLessonPage
                .fillLessonThemeInput(error.getTheme())
                .verifyThemeNameInputFieldIsFilled(error.getTheme())
                .loseFocus()
                .verifyThemeNameError(error.getResult())
                .fillTimeInput(LocalDateTime.now().minusDays(1)
                        .format(DateTimeFormatter.ofPattern("ddMMyyyyHH:mm")))
                .verifyDateInputFieldIsFilled()
                .verifyAll();
    }
}
