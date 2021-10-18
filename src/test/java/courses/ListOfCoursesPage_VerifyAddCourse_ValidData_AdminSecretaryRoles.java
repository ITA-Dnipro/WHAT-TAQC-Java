package courses;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRoles extends BaseTest {

    private AddCoursePage addCoursesPage;
    private CoursesPage coursesPage;
    private String courseName;

    @BeforeMethod
    public void preconditions() throws IOException {
        coursesPage = new CoursesPage(driver);
        addCoursesPage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.ADD_COURSE, AddCoursePage.class);
    }

    @Test(description = "DP213-42")
    public void addCourse() throws IOException {
        courseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + " 7";
        String expectedResult = "×\nClose alert\nThe course has been successfully added";

        addCoursesPage
                .fillInputAddCourseName(courseName)
                .saveNewCourse()
                .fillCourseSearchField(" ")
                .isAtPage(waitTime)
                .fillCourseSearchField(courseName);

        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), courseName);
        Assert.assertEquals(coursesPage.getAlertAddCourse().getText(), expectedResult);

        addCoursesPage.logOut();
        addCoursesPage.redirectTo(Endpoints.AUTH, AuthPage.class);
    }
}