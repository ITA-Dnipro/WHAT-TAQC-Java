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

public class UnassignedUsersPage_VerifyAddMentorsRole extends BaseTest {
    private UnassignedUser mentor;

    @BeforeClass
    public void setUp () {
        mentor = UnassignedUser.getUnassignedUser();
    }
    @Test
    public void verifyAddMentorRole() throws IOException {
        List<String> actualData=AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .inputSearchMentor("a")
                .inputSearchMentor(mentor.getFirstName()+" "+ mentor.getLastName())
                .getMentorsData();
        List<String> exceptData= Arrays.asList(mentor.getFirstName(),mentor.getLastName(),mentor.getEmail());
        Assert.assertEquals(actualData,exceptData);
    }

    }



