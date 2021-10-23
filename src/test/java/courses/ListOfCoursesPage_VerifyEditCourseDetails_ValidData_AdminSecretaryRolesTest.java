package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseValidData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRolesTest extends BaseTest {

    CoursesPage coursesPage;
    EditCourseValidData[] data;
    String addedCourseName;
    String newName;

    public ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRolesTest() throws IOException {
        data = EditCourseValidData.getEditCoursesValidData(PathsToFiles.Courses.EDIT_COURSES_VALID_DATA);
    }

    @BeforeClass
    public void setUp() throws IOException {
        addedCourseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(6) + " 2";

        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .redirectToAddCoursePage()
                .fillInputAddCourseName(addedCourseName)
                .saveNewCourse()
                .isAtPage(waitTime);
    }


    @Test(description = "DP213-43")
    public void verifyEditCourseValidData() throws IOException {
        newName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(10) + " 5";
        coursesPage = new CoursesPage(driver);

        coursesPage.fillCourseSearchField(addedCourseName)
                .isAtPage(waitTime)
                .clickEditCourseDetailsTab(0)
                .isAtPage(waitTime)
                .fillCourseName(newName)
                .saveChangeCurseName()
                .isAtPage(waitTime)
                .fillCourseSearchField(" ")
                .fillCourseSearchField(addedCourseName)
                .isAtPage(waitTime)
                .verifyOldCourseNameExist(addedCourseName)
                .isAtPage(waitTime)
                .fillCourseSearchField(newName)
                .isAtPage(waitTime)
                .assertAllCoursePages()
                .verifyCourseNameEdited(newName)
                .logOut();
    }
}
