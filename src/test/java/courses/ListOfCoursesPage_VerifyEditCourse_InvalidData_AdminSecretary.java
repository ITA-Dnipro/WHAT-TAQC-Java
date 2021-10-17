package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseInvalidData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretary extends BaseTest {

    CoursesPage coursesPage;
    EditCourseInvalidData[] data;

    public ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretary() throws IOException {
        data = EditCourseInvalidData.getEditCoursesInvalidData(PathsToFiles.Сourses.EDIT_COURSES_INVALID_DATA);
    }

    @DataProvider(name = "editCourseInvalidData")
    public Object[][] getInvalidData() {
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(description = "DP213-45", dataProvider = "editCourseInvalidData")
    public void verifyEditCourse_InvalidData(EditCourseInvalidData editData) throws IOException, InterruptedException {
        coursesPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .fillCourseSearchField(editData.getCourseName())
                .isAtPage(waitTime)
                .clickEditCourseDetailsTab(0)
                .fillCourseName(editData.getNewCourseName())
                .verifyEditCourseError(editData.getMessage())
                .clearChanges()
                .outFromEditCourseDetails();

        Assert.assertEquals(driver.getCurrentUrl(), Endpoints.COURSES);
    }
}
