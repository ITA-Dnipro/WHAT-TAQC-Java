package mentors;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.students.StudentsPage;
import page.mentors.EditMentorsDetailsPage;
import page.mentors.MentorsTablePage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class EditMentorsDetailsPage_VerifyEditMentors_IncorrectData extends BaseTest {
    InvalidData[] data;
    String nameMentors ;
    String surNameMentors ;
    String passwordMentors ;
    String emailMentors ;
    UnassignedUser mentor;
   EditMentorsDetailsPage editMentorsPage;

    public EditMentorsDetailsPage_VerifyEditMentors_IncorrectData() throws IOException {
        nameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        mentor= UnassignedUser.getUnassignedUser(nameMentors,surNameMentors,emailMentors,passwordMentors);
        data=InvalidData.getData(PathsToFiles.Mentors.EDIT_MENTOR_ERRORS);
    }

    @BeforeClass
    public void precondition() throws IOException, InterruptedException {

        editMentorsPage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .inputSearchMentor("a")
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0).isAtPage(waitTime);
    }

    @DataProvider(name = "errors")
    public Object[][] provide() {
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(dataProvider = "errors")
    public void checkFirstNameErrors(InvalidData firstName) {
        String expectedResult= firstName.getErrorName();
        String actualResult= editMentorsPage.editName(firstName.getName())
                .loseFocus().getFirstNameError();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
