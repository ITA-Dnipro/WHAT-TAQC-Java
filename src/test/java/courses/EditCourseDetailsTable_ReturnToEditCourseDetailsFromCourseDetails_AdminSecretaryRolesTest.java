package courses;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;
import page.courses.EditCourseDetailsTab;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;

public class EditCourseDetailsTable_ReturnToEditCourseDetailsFromCourseDetails_AdminSecretaryRolesTest extends BaseTest {

    private EditCourseDetailsTab editCourseDetailsTab;
    private String courseName;

    @BeforeMethod
    public void setUp() throws IOException{
        courseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(8) + " 1";

        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.ADD_COURSE, AddCoursePage.class)
                .fillInputAddCourseName(courseName)
                .saveNewCourse()
                .logOut();
    }

    @DataProvider(name = "redirectToEditCourseTab")
    public Object[][] getData() {
        return new Object[][]{{Role.ADMIN}};
    }

    @Test(description = "DP213-141", dataProvider = "redirectToEditCourseTab")
    public void verifyRedirectToEditCourseTabAfterRefresh(Role role) throws IOException {
        editCourseDetailsTab = new EditCourseDetailsTab(driver);
        String courseDetailsTabTitle = "Course Editing";

        AuthPage.init(driver)
                .logInAs(role, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .fillCourseSearchField(courseName)
                .verifySearchCourseFieldFilled(courseName)
                .isAtPage(waitTime)
                .clickEditCourseDetailsTab(0)
                .isAtPage(waitTime)
                .redirectToCourseDetailsTab()
                .refreshPage()
                .isAtPage(waitTime)
                .verifyReturnToEditCourseDetailsTabAfterRefresh(courseDetailsTabTitle)
                .isAtPage(waitTime);
    }
}
