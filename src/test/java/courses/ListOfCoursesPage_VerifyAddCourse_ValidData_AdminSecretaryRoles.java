package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.AddCoursesData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.AddCoursePage;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRoles extends BaseTest {

    private AddCoursesData[] courseNameList;
    private AddCoursePage addCoursesPage;
    private CoursesPage coursesPage;

    public ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRoles() throws IOException {
        courseNameList = AddCoursesData.getCoursesName(PathsToFiles.Courses.ADD_COURSES_VALID_DATA);
    }

    @BeforeMethod
    public void preconditions() throws IOException {
        coursesPage = new CoursesPage(driver);
        addCoursesPage = AuthPage
                .init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.ADD_COURSE, AddCoursePage.class);
    }

    @DataProvider(name = "changeName")
    public Object[][] provideCredentials() {
        return new Object[][]{{courseNameList[0]}, {courseNameList[1]}};
    }

    @Test(description = "DP213-42", dataProvider = "changeName")
    public void addCourse(AddCoursesData data) throws IOException {

        String expectedResult = "×\nClose alert\nThe course has been successfully added";

        addCoursesPage
                .fillInputAddCourseName(data.getСourseName())
                .saveNewCourse()
                .fillCourseSearchField(" ")
                .isAtPage(waitTime)
                .fillCourseSearchField(data.getСourseName());

        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), data.getСourseName());
        Assert.assertEquals(coursesPage.getAlertAddCourse().getText(), expectedResult);

        addCoursesPage.logOut();
        addCoursesPage.redirectTo(Endpoints.AUTH, AuthPage.class);
    }
}