package courses;

import base.BaseTest;
import constants.PathsToFiles;
import courses.coursesData.EditCourseInvalidData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.base.SideBar;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretaryTest extends BaseTest {

    private StudentsPage studentsPage;
    private EditCourseInvalidData[] data;

    public ListOfCoursesPage_VerifyEditCourse_InvalidData_AdminSecretaryTest() throws IOException {
        data = EditCourseInvalidData.getEditCoursesInvalidData(PathsToFiles.Courses.EDIT_COURSES_INVALID_DATA);
    }

    @BeforeClass
    public void setUp() throws IOException {
        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime);
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
    public void verifyEditCourseInvalidData(EditCourseInvalidData editData) {
        studentsPage = new StudentsPage(driver);

        studentsPage
                .getSideBar()
                .clickSideBarItem(SideBar.SideMenuItem.COURSES, new CoursesPage(driver))
                .isAtPage(waitTime)
                .fillCourseSearchFields(editData.getCourseName())
                .isAtPage(waitTime)
                .verifySearchCourseFieldFilled(editData.getCourseName())
                .clickEditCourseDetailsTab(0)
                .isAtPage(waitTime)
                .fillCourseName(editData.getNewCourseName())
                .isAtPage(waitTime)
                .verifyCourseNameFieldFilled(editData.getNewCourseName())
                .isAtPage(waitTime)
                .verifyEditCourseError(editData.getMessage())
                .assertAllCoursePage()
                .isAtPage(waitTime)
                .clearChanges()
                .isAtPage(waitTime)
                .redirectOutFromEditCourseDetails()
                .isAtPage(waitTime);
    }
}
