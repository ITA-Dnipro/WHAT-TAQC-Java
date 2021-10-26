package courses;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRolesTest extends BaseTest {

    private AddCoursePage addCoursesPage;
    private CoursesPage coursesPage;
    private String courseName;

    @BeforeMethod
    public void setUp() throws IOException {
        coursesPage = new CoursesPage(driver);
        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.ADD_COURSE, AddCoursePage.class);
    }

    @Test(description = "DP213-42")
    public void VerifyAddCourse() throws IOException {
        courseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + " 2";
        String expectedResult = "×\nClose alert\nThe course has been successfully added";
        addCoursesPage = new AddCoursePage(driver);

        addCoursesPage
                .fillInputAddCourseName(courseName)
                .verifyAddCourseFieldFilled(courseName)
                .saveNewCourse()
                .isAtPage(waitTime)
                .fillCourseSearchField(courseName)
                .verifySearchCourseFieldFilled(courseName)
                .verifyCourseExists(courseName)
                .verifyAddCourseAlertExist(expectedResult)
                .logOut();
    }
}