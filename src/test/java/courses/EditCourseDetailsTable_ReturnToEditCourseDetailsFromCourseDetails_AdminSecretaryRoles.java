package courses;

import base.BaseTest;
import constants.Endpoints;
import org.openqa.selenium.By;
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

import static constants.Locators.CourseDetailsPage.EDIT_COURSE_DETAILS_TAB_TITLE_XPATH;

public class EditCourseDetailsTable_ReturnToEditCourseDetailsFromCourseDetails_AdminSecretaryRoles extends BaseTest {

    EditCourseDetailsTab coursesPage;
    AuthPage authPage;
    String courseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(8);

    @BeforeMethod
    public void preconditions() throws IOException, InterruptedException {
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
        return new Object[][] {{Role.ADMIN}};
    }

    @Test(description = "DP213-141", dataProvider = "redirectToEditCourseTab")
    public void verifyEditCourse_InvalidData(Role role) throws IOException, InterruptedException {

        String courseDetailsTabTitle = "Course Editing";

        coursesPage = AuthPage.init(driver)
                .logInAs(role, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .fillCourseSearchField(" ")
                .isAtPage(waitTime)
                .fillCourseSearchField(courseName)
                .isAtPage(waitTime)
                .clickEditCourseDetailsTab(0)
                .redirectToCourseDetailsTab()
                .refreshPage();

        Assert.assertEquals(driver.findElement(By.xpath(
                EDIT_COURSE_DETAILS_TAB_TITLE_XPATH)).getText(), courseDetailsTabTitle);
    }
}
