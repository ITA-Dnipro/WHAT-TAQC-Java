package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class MentorDetailsPage_VerifyViewingOfMentorsDetails_FromMantorsTablePage_AdminRole extends BaseTest {

    UnassignedUser mentor;
    MentorsTablePage mentorsTablePage;

    public MentorDetailsPage_VerifyViewingOfMentorsDetails_FromMantorsTablePage_AdminRole() {
        mentor = UnassignedUser.getUnassignedUser();
    }

    @BeforeClass
    public void setUp() throws IOException {

        mentorsTablePage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime)
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName());
    }
        @Test(description = "DP213-149")
    public void verifyViewingOfMentorsDetails_FromMentorsTablePage(){
        mentorsTablePage.viewMentorsDetails(0)
                .verifyFirstName(mentor.getFirstName())
                .verifyLastName(mentor.getLastName())
                .verifyEmail(mentor.getEmail())
                .assertAll();
        }

}
