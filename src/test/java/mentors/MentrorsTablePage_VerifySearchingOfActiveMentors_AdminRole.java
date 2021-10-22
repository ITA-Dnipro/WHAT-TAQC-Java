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
import java.util.Arrays;
import java.util.List;

public class MentrorsTablePage_VerifySearchingOfActiveMentors_AdminRole extends BaseTest {
    String nameMentors;
    String surNameMentors;
    String passwordMentors;
    String emailMentors;
    UnassignedUser mentor;
    MentorsTablePage mentorsTablePage;

    public MentrorsTablePage_VerifySearchingOfActiveMentors_AdminRole() throws IOException {
        nameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        mentor = UnassignedUser.getUnassignedUser(nameMentors, surNameMentors, emailMentors, passwordMentors);
    }

    @BeforeClass
    public void precondition() throws IOException {

        mentorsTablePage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class);
    }

    @Test(description = "DP213-167")
    public void verifySearchingOfActiveMentors() {
        String invalidData="6";
        List<String> expectFound = Arrays.asList(nameMentors, surNameMentors, emailMentors);
        mentorsTablePage.inputSearchMentor(nameMentors + " " + surNameMentors)
                .verifyInputSearchField(nameMentors + " " + surNameMentors)
                .verifyMentorsDataInTheTable(expectFound)
                .inputSearchMentor(invalidData)
                .verifyInputSearchField(invalidData)
                .verifyNotFoundResult()
                .assertAll();
    }
}