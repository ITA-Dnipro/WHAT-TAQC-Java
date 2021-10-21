package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.SearchFunctionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyCourseSearchField_InvalidData_AnyUserRoleTest extends BaseTest{

        private SearchFunctionTest[] searchName;

        public ListOfCoursesPage_VerifyCourseSearchField_InvalidData_AnyUserRoleTest() throws IOException {
            searchName = SearchFunctionTest.getCourseNameForSearch(PathsToFiles.Courses.SEARCH_COURSES_NAME);
        }

        @DataProvider(name = "course-nameNegative")
        public Object[][] getCourseNameNegative() {
            return new Object[][]{{searchName[1]}};
        }

        @Test(description = "DP213-79", dataProvider = "course-nameNegative", priority = 2)
        public void verifySearchFunctionNegativeData(SearchFunctionTest name) throws IOException {
            String expectedResult = "Course is not found";

            AuthPage.init(driver)
                    .logInAs(Role.MENTOR, LessonsPage.class)
                    .isAtPage(waitTime)
                    .redirectTo(Endpoints.COURSES, CoursesPage.class)
                    .isAtPage(waitTime)
                    .fillCourseSearchField(name.getCourseName())
                    .isAtPage(waitTime)
                    .verifyCourseExists(expectedResult)
                    .logOut();
        }
    }
