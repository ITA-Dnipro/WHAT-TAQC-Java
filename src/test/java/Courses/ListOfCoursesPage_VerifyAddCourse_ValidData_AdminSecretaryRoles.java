package Courses;

import base.BaseTest;
import Courses.coursesData.AddCoursesData;
import Courses.coursesData.UserForCourses;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ListOfCoursesPage_VerifyAddCourse_ValidData_AdminSecretaryRoles extends BaseTest {

    private ObjectMapper mapper;
    private AddCoursesData[] courseNameList;
    private UserForCourses[] userList;
    private CoursesPage coursesPage;
    private LogIn login;

    @BeforeClass
    public void preconditions() throws IOException {
        mapper = new ObjectMapper();
        login = new LogIn(driver);
        driver.get(Endpoints.BASE_URL);
        userList = mapper.readValue(
                new File("./src/main/resources/credentials.json"), UserForCourses[].class);
        courseNameList = mapper.readValue(
                new File("./src/main/resources/courses/addCourses/AddCourses_ValidData.json"), AddCoursesData[].class);

        login.fillMail(userList[0].getMail())
                .fillPass(userList[0].getPass())
                .clickLogInButton();
        wait.until(url -> !(driver.getCurrentUrl().equals(Endpoints.AUTH)));
    }

    @DataProvider(name = "changeName")
    public Object[][] provideCredentials() {
        return new Object[][]{{userList[0], courseNameList[0]}, {userList[0], courseNameList[1]}};
    }

    @Test(dataProvider = "changeName")
    public void addCourse(UserForCourses user, AddCoursesData data) throws InterruptedException {
        coursesPage = new CoursesPage(driver);
        driver.get(Endpoints.COURSES);
        wait.until(url -> (driver.getCurrentUrl().equals(Endpoints.COURSES)));
        this.coursesPage.addCoursePage()
                .inputAddCourseName(data.getСourseName())
                .saveNewCourse().fillCourseSearchField(data.getСourseName());
//        wait.until(ExpectedConditions.visibilityOf(coursesPage.getCoursesRowsList().get(0)));
        Thread.sleep(4000);
        Assert.assertEquals(this.coursesPage.getCoursesRowsList().get(0).getText(), data.getСourseName());
    }
}


