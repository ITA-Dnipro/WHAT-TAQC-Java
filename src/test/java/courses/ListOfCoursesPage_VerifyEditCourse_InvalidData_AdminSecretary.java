package courses;

import base.BaseTest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseData;
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
    EditCourseData[] data;

    public ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretary() throws IOException {
        data = EditCourseData.getEditCoursesData(PathsToFiles.Сourses.EDIT_COURSES_INVALID_DATA);
    }

    @DataProvider(name = "editCourseData")
    public Object[][] getData() {
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(description = "Dp-213 TAQC", dataProvider = "editCourseData")
    public void verifyEditCourse_InvalidData(EditCourseData editData) throws IOException, InterruptedException {
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
