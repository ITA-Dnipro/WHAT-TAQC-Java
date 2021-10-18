package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.SearchFunctionTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyCourseSearchField_ValidValidData_AnyUserRole extends BaseTest {

    private SearchFunctionTest[] searchName;
    private CoursesPage coursesPage;

    public ListOfCoursesPage_VerifyCourseSearchField_ValidValidData_AnyUserRole() throws IOException {
        searchName = SearchFunctionTest.getCourseNameForSearch(PathsToFiles.Сourses.SEARCH_COURSES_NAME);
    }

    @DataProvider(name = "course-namePositive")
    public Object[][] getCourseName() {
        return new Object[][]{{searchName[0]}};
    }

    @Test(description = "DP213-79", dataProvider = "course-namePositive", priority = 1)
    public void verifySearchFunctionPositiveData(SearchFunctionTest name) throws IOException{
       coursesPage = new CoursesPage(driver);

        coursesPage = AuthPage.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .fillCourseSearchField(name.getCourseName());

        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), name.getCourseName());

       coursesPage.logOut()
                .isAt();
    }

    @DataProvider(name = "course-nameNegative")
    public Object[][] getCourseNameNegative() {
        return new Object[][]{{searchName[1]}};
    }

    @Test(description = "DP213-79", dataProvider = "course-nameNegative", priority = 2)
    public void verifySearchFunctionNegativeData(SearchFunctionTest name) throws IOException, InterruptedException {
        String expectedResult = "Course is not found";

        coursesPage = AuthPage.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .fillCourseSearchField(name.getCourseName())
                .isAtPage(waitTime);
        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), expectedResult);

        coursesPage.logOut()
                .isAt();
    }
}