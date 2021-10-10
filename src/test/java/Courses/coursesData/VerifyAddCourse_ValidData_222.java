package Courses.coursesData;

import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import lessons.data.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.courses.CoursesPage;

import java.io.IOException;

public class VerifyAddCourse_ValidData_222 extends BaseTest {

    private ObjectMapper mapper = new ObjectMapper();
    private AddCoursesData[] courseNameList;
    private User user;
    private CoursesPage coursesPage = new CoursesPage(driver);

    @BeforeClass
    public void preconditions() throws IOException {
        LogIn login = new LogIn(driver);
        driver.get(Endpoints.BASE_URL);
        login.fillMail("james.smith@example.com")
                .fillPass("_JkcG9dB").clickLogInButton();
        wait.until(url -> !(driver.getCurrentUrl().equals(Endpoints.AUTH)));
    }

    @Test()
    public void addCourse() throws InterruptedException {
        Thread.sleep(4000);
        driver.get(Endpoints.COURSES);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.Courses.ADD_COURSE_BUTTON_XPATH)));
        Thread.sleep(3000);
        coursesPage.addCoursePage()
                .inputAddCourseName("Course 22")
                .saveNewCourse().fillCourseSearchField("Course 22");

            Assert.assertEquals(coursesPage.getCoursesRowsList().get(0), "Course 22");
        }
    }


