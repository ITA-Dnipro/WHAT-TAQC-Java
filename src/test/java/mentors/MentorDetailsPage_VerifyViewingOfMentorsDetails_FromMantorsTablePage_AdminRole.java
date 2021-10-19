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
    String nameMentors;
    String lastNameMentors;
    String passwordMentors;
    String emailMentors;
    UnassignedUser mentor;
    MentorsTablePage mentorsTablePage;

    public MentorDetailsPage_VerifyViewingOfMentorsDetails_FromMantorsTablePage_AdminRole() {
        nameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        lastNameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        mentor = UnassignedUser.getUnassignedUser(nameMentors, lastNameMentors, emailMentors, passwordMentors);
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
                .verifyFirstName(nameMentors)
                .verifyLastName(lastNameMentors)
                .verifyEmail(emailMentors)
                .assertAll();
        }

}
