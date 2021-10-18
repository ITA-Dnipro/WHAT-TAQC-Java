package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseInvalidData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.courses.CoursesPage;
import page.courses.EditCourseDetailsTab;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretary extends BaseTest {

    private CoursesPage coursesPage;
    private EditCourseInvalidData[] data;
    private SoftAssert softAssert;

    public ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretary() throws IOException {
        data = EditCourseInvalidData.getEditCoursesInvalidData(PathsToFiles.Сourses.EDIT_COURSES_INVALID_DATA);
    }

    @BeforeClass
    public void preconditions() throws IOException {
        coursesPage = AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class);
    }

        @DataProvider(name = "editCourseInvalidData")
        public Object[][] getInvalidData () {
            Object[][] list = new Object[data.length][1];
            for (int i = 0; i < data.length; i++) {
                list[i][0] = data[i];
            }
            return list;
        }

        @Test(description = "DP213-45", dataProvider = "editCourseInvalidData")
        public void verifyEditCourse_InvalidData (EditCourseInvalidData editData) {
            softAssert = new SoftAssert();

                coursesPage.fillCourseSearchField(editData.getCourseName())
                    .isAtPage(waitTime)
                    .clickEditCourseDetailsTab(0)
                    .isAtPage(waitTime)
                    .fillCourseName(editData.getNewCourseName())
                    .verifyEditCourseError(editData.getMessage())
                    .clearChanges()
                    .outFromEditCourseDetails()
                    .isAtPage(waitTime);

            softAssert.assertAll();
            Assert.assertEquals(driver.getCurrentUrl(), Endpoints.COURSES);
        }
    }
