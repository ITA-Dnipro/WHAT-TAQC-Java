package students;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class StudentsEditDetailsTab extends BaseTest {
    private StudentsPage studentsPage;
    private SoftAssert softAsserts;
    private UnassignedUser user;

    @BeforeClass
    public void precondition() throws IOException {
        user = UnassignedUser.getUnassignedUser();
        AuthPage.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .addStudent()
                .addRole(user.getEmail(), UnassignedRole.STUDENT)
                .logOut();
    }

//    @Test
//    public void verifyEditStudentFeatureAdminRole() throws IOException {
//        AuthPage.init(driver)
//                .logInAs()
//                .findStudentRowInTableByEmail(user.getEmail())
//
//    }
}
