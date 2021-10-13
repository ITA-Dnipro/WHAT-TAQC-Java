package Courses;

import Courses.coursesData.AddCoursesData;
import base.BaseTest;
import base.Role;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRoles extends BaseTest {

    private AddCoursesData[] courseNameList;
    private CoursesPage coursesPage;

    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        courseNameList = helper.getMapper().readValue(
                new File(PathsToFiles.Сourses.ADD_COURSES_VALID_DATA), AddCoursesData[].class);
    }

    @DataProvider(name = "changeName")
    public Object[][] provideCredentials() {
        return new Object[][]{{Role.ADMIN, courseNameList[0]}, {Role.ADMIN, courseNameList[1]}};
    }

    @Test(dataProvider = "changeName")
    public void addCourse(Role role, AddCoursesData data) {

        String expectedResult = "×\nClose alert\nThe course has been successfully added";
        coursesPage = new CoursesPage(driver);
        SoftAssert softAssert = new SoftAssert();

        helper.logInAs(role);

        helper.waitForRedirectFrom(Endpoints.AUTH);
        driver.get(Endpoints.COURSES);

        this.coursesPage
                .addCoursePage()
                .inputAddCourseName(data.getСourseName())
                .saveNewCourse();
        helper.waitForVisibilityOfElement(coursesPage.alertAddCourse());
        softAssert.assertEquals(coursesPage.alertAddCourse(), expectedResult);
        softAssert.assertAll();

        coursesPage.getHeader().logOut();
    }
}


