package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class UnassignedUsersPage_VerifyAddStudentRole extends BaseTest {
    private UnassignedUser student;
    StudentsPage studentsPage;

    public UnassignedUsersPage_VerifyAddStudentRole() {
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
    public void VerifyEditStudentDetails_CorrectData() throws IOException{

            List<String> actualData=AuthPage.init(driver)
                    .clickRegistrationLink()
                    .registerUser(student)
                    .logInAs(Role.ADMIN, StudentsPage.class)
                    .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                    .addRole(student.getEmail(), UnassignedRole.STUDENT)
                    .redirectTo(Endpoints.STUDENTS, StudentsPage.class)
                    .fillSearch("a")
                    .fillSearch(student.getFirstName()+" "+ student.getLastName())
                    .getStudentData();
            List<String> exceptData= Arrays.asList(student.getFirstName(),student.getLastName(),student.getEmail());
            Assert.assertEquals(actualData,exceptData);
        }
    }




