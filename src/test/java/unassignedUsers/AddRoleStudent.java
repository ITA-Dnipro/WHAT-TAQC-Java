package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;
import java.io.IOException;


public class AddRoleStudent extends BaseTest {
    private UnassignedUser student;
    StudentsPage studentsPage;

    public AddRoleStudent() {
        student = UnassignedUser.getUnassignedUser();
    }

    @BeforeClass

    public void setUp() throws IOException {
        studentsPage= AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(student)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(student.getEmail(), UnassignedRole.STUDENT)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.STUDENTS, StudentsPage.class)
                .fillSearch(student.getFirstName()+" "+student.getLastName())
                .isAtPage(waitTime);

    }
    @Test
    public void VerifyEditMentorDetails_CorrectData(){
    }
}



