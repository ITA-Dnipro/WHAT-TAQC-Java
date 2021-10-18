package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseValidData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRoles extends BaseTest {

    CoursesPage coursesPage;
    EditCourseValidData[] data;
    String currentName;
    String newName;

    public ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRoles() throws IOException {
        data = EditCourseValidData.getEditCoursesValidData(PathsToFiles.Courses.EDIT_COURSES_VALID_DATA);
    }

    @DataProvider(name = "editCourseValidData")
    public Object[][] getValidData() {
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(description = "DP213-43", dataProvider = "editCourseValidData")
    public void verifyEditCourse_ValidData(EditCourseValidData editData) throws IOException{

        String expectedResult = "×\nClose alert\nThe course has been successfully edited";

        coursesPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .fillCourseSearchField(editData.getCourseName())
                .clickEditCourseDetailsTab(0)
                .isAtPage(waitTime)
                .fillCourseName(editData.getNewCourseName())
                .saveChangeCurseName()
                .isAtPage(waitTime)
                .fillCourseSearchField(editData.getCourseName())
                .verifyOldCourseNameExist(editData.getCourseName())
                .isAtPage(waitTime)
                .fillCourseSearchField(editData.getNewCourseName())
                .isAtPage(waitTime);
        //coursesPage.getSoftAssert().assertAll();

        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), editData.getNewCourseName());
        Assert.assertEquals(coursesPage.getAlertAddCourse().getText(), expectedResult);

        coursesPage.logOut();
    }
}
