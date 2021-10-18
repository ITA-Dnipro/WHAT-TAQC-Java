package courses;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
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

public class EditCourseDetailsTable_ReturnToEditCourseDetailsFromCourseDetails_AdminSecretaryRoles extends BaseTest {

    private EditCourseDetailsTab editCourseDetailsTab;
    private EditCourseDetailsTab coursesPage;
    private AuthPage authPage;
    private String courseName;

    @BeforeMethod
    public void preconditions() throws IOException, InterruptedException {
        courseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(8);

        authPage = AuthPage
                .init(driver)
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
    public void verifyEditCourse_InvalidData(Role role) throws IOException, InterruptedException {
        editCourseDetailsTab = new EditCourseDetailsTab(driver);
        String courseDetailsTabTitle = "Course Editing";

        coursesPage = AuthPage.init(driver)
                .logInAs(role, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .fillCourseSearchField(courseName)
                .isAtPage(waitTime)
                .clickEditCourseDetailsTab(0)
                .redirectToCourseDetailsTab()
                .refreshPage()
                .isAtPage(waitTime);

        Assert.assertEquals(editCourseDetailsTab.getEditTabTitle().getText(), courseDetailsTabTitle);
    }
}
