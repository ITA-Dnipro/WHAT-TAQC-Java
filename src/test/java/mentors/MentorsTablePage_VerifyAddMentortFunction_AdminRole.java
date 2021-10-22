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
    String nameMentors;
    String surNameMentors;
    String passwordMentors;
    String emailMentors;
    UnassignedUser mentor;
    MentorsTablePage mentorsTablePage;

    public MentorsTablePage_VerifyAddMentortFunction_AdminRole() {
        nameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        mentor = UnassignedUser.getUnassignedUser(nameMentors, surNameMentors, emailMentors, passwordMentors);
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
        List<String> exceptData = Arrays.asList(nameMentors, surNameMentors, emailMentors);
        mentorsTablePage
                .addMentor()
                .isAtPage(waitTime)
                .addRole(emailMentors, UnassignedRole.MENTOR)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .isAtPage(waitTime)
                .inputSearchMentor(nameMentors + " " + surNameMentors)
                .verifyInputSearchField(nameMentors + " " + surNameMentors)
                .verifyMentorsDataInTheTable(exceptData)
                .assertAll();

    }
}