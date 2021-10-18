package courses;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import courses.coursesData.EditCourseValidData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.courses.CoursesPage;
import page.students.StudentsPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;

import java.io.IOException;

public class ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRoles extends BaseTest {

    CoursesPage coursesPage;
    EditCourseValidData[] data;
    String addedCourseName;
    String newName;

    public ListOfCoursesPage_VerifyEditCourseDetails_ValidData_AdminSecretaryRoles() throws IOException {
        data = EditCourseValidData.getEditCoursesValidData(PathsToFiles.Сourses.EDIT_COURSES_VALID_DATA);
    }

    @BeforeClass
    public void precondition() throws IOException {
        addedCourseName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(6) + " 2";

        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.COURSES, CoursesPage.class)
                .isAtPage(waitTime)
                .addCoursePage()
                .fillInputAddCourseName(addedCourseName)
                .saveNewCourse()
                .isAtPage(waitTime);
    }


    @Test(description = "DP213-43")
    public void verifyEditCourse_ValidData() throws IOException {
        newName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(10) + " 2";
        String expectedResult = "×\nClose alert\nThe course has been successfully added";
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
                .isAtPage(waitTime);
        coursesPage.getSoftAssert().assertAll();

        Assert.assertEquals(coursesPage.getCoursesRowsList().get(0).getText(), newName);
        Assert.assertEquals(coursesPage.getAlertAddCourse().getText(), expectedResult);

        coursesPage.logOut();
    }
}
