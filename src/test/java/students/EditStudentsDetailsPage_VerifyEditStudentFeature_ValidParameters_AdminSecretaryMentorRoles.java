package students;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class EditStudentsDetailsPage_VerifyEditStudentFeature_ValidParameters_AdminSecretaryMentorRoles extends BaseTest {
    private UnassignedUser student;
    private Integer timeout = 3000;
    private String newName;
    private String newEmail;

    @BeforeClass
    public void setUp() throws IOException {
        student = UnassignedUser.getUnassignedUser();
        AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(student)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(timeout)
                .addStudent()
                .addRole(student.getEmail(), UnassignedRole.STUDENT)
                .logOut();
        newName = RandomStringsGenerator.getRandomName();
        newEmail = RandomStringsGenerator.getRandomEmail();
    }

    @Test(description = "DP213-216")
    public void verifyEditStudent() throws IOException {
        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.STUDENTS, StudentsPage.class)
                .isAtPage(timeout)
                .openStudentEditDetailsTab(student)
                .verifyFillingFirstNameInputField(student.getFirstName())
                .verifyFillingLastNameInputField(student.getLastName())
                .verifyFillingEmailInputField(student.getEmail())
                .verifyButtonsAreEnabled(true, false, false)
                .fillInputFirstName(newName)
                .verifyButtonsAreEnabled(false, true, true)
                .fillInputLastName(newName)
                .verifyButtonsAreEnabled(false, true, true)
                .fillInputEmail(newEmail)
                .verifyButtonsAreEnabled(false, true, true)
                .clickSaveButton()
                .isAtPage(waitTime)
                .isStudentPresented(newEmail);
    }

}
