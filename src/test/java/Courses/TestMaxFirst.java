package Courses;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.auth.AuthPage;
import page.base.SideBar;
import page.courses.CoursesPage;



public class TestMaxFirst extends BaseTest {

    private String authUrlLink = "http://localhost:8080/auth";



    @Test
    public void cancelCourse() throws InterruptedException {
        AuthPage authPage = new AuthPage(driver);
        driver.get(authUrlLink);
        Thread.sleep(4000);
//        authPage.loginUserAdmin(VasyaAdmin)
//                .getSideBar()
//                .clickSideBarItem(SideBar.SideMenuItem.COURSES, new CoursesPage(driver))
//                .editCourseDetailsTab(2)
//                .cancelDeleteAction()
//                .getSideBar()
//                .clickSideBarItem(SideBar.SideMenuItem.COURSES, new CoursesPage(driver));
    }
    SoftAssert sa = new SoftAssert();

}
