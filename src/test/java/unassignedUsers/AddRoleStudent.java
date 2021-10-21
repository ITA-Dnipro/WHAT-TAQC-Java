package unassignedUsers;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AddRoleStudent extends BaseTest {
        private UnassignedUser student;

        @BeforeClass
        public void setUp () {
            student = UnassignedUser.getUnassignedUser();
        }
        @Test
        public void verifyAddStudentRole() throws IOException {
            List<String> actualData= AuthPage.init(driver)
                    .clickRegistrationLink()
                    .registerUser(student)
                    .logInAs(Role.ADMIN, StudentsPage.class)
                    .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                    .addRole(student.getEmail(), UnassignedRole.STUDENT)
                    .redirectTo(Endpoints.STUDENTS, StudentsPage.class)
                    .inputSearchStudent("a")
                    .inputSearchStudent(student.getFirstName()+" "+ student.getLastName())
                    .getStudentData();
            List<String> exceptData= Arrays.asList(student.getFirstName(),student.getLastName(),student.getEmail());
            Assert.assertEquals(actualData,exceptData);
        }

    }

