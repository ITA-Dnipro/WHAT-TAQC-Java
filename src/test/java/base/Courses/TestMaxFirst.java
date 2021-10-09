package base.Courses;

import base.BaseTest;
import constants.Locators;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.auth.AuthPage;
import page.base.SideBar;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import testUI.Admin;
import testUI.User;


public class TestMaxFirst extends BaseTest {

    private String authUrlLink = "http://localhost:8080/auth";

    User VasyaAdmin = new Admin("james.smith@example.com", "_JkcG9dB");

    @Test
    public void cancelCourse() throws InterruptedException {
        AuthPage authPage = new AuthPage(driver);
        driver.get(authUrlLink);
        Thread.sleep(4000);
        authPage.loginUserAdmin(VasyaAdmin)
                .getSideBar()
                .clickSideBarItem(SideBar.SideMenuItem.COURSES, new CoursesPage(driver))
                .editCourseDetailsTab(2)
                .cancelDeleteAction()
                .getSideBar()
                .clickSideBarItem(SideBar.SideMenuItem.COURSES, new CoursesPage(driver));
    }
    SoftAssert sa = new SoftAssert();

}
