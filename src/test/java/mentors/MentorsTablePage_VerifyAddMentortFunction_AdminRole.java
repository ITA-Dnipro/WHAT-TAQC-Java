package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MentorsTablePage_VerifyAddMentortFunction_AdminRole extends BaseTest {
    UnassignedUser mentor;
    MentorsTablePage mentorsTablePage;

    public MentorsTablePage_VerifyAddMentortFunction_AdminRole() {
        mentor = UnassignedUser.getUnassignedUser();
    }

    @BeforeClass
    public void setUp() throws IOException {
        mentorsTablePage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime);
    }

    @Test(description = "DP213-159")
    public void verifyAddMentorFunction() {
        List<String> exceptData = Arrays.asList(mentor.getFirstName(), mentor.getLastName(), mentor.getEmail());
        mentorsTablePage
                .addMentor()
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime)
                .inputSearchMentor(mentor.getFirstName() + " " + mentor.getLastName())
                .verifyInputSearchField(mentor.getFirstName() + " " + mentor.getLastName())
                .verifyMentorsDataInTheTable(exceptData)
                .assertAll();

    }
}
