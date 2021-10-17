package lessons;

import constants.PathsToFiles;
import lessons.data.EditLessonError;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.lessons.EditLessonPage;

import java.io.IOException;

public class EditLesson_VerifyErrorMessages extends EditLesson_VerifyEditLesson_CorrectData_AdminRole{

    EditLessonError[] errors;
    EditLessonPage editLessonPage;

    public EditLesson_VerifyErrorMessages() throws IOException {
        this.errors = EditLessonError.getErrors(PathsToFiles.Lessons.EDIT_LESSON_ERRORS);
    }

    @BeforeClass
    @Override
    public void precondition() throws IOException {
        super.precondition();
        editLessonPage = lessonsPage
                .clickEditIcon(0)
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
    public void verifyThemeInputErrors(EditLessonError error) {

        String expectedResult = error.getResult();

        String actualResult = editLessonPage
                .fillLessonThemeInput(error.getTheme())
                .loseFocus()
                .getThemeInputError();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
