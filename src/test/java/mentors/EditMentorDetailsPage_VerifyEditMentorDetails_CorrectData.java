package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.mentors.EditMentorsDetailsPage;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;
import java.io.IOException;

public class EditMentorDetailsPage_VerifyEditMentorDetails_CorrectData extends BaseTest {
    String nameMentors ;
    String surNameMentors ;
    String passwordMentors ;
    String emailMentors ;
    String newNameOfMentors;
    String newSurNameOfMentors;
    String newEmailOfMentors;
    UnassignedUser mentor;
    EditMentorsDetailsPage editMentor;
    String editMentorURL;

    public EditMentorDetailsPage_VerifyEditMentorDetails_CorrectData() {
        nameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailMentors = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        newNameOfMentors=nameMentors+"new";
        newSurNameOfMentors=surNameMentors+"new";
        newEmailOfMentors=emailMentors+"new";
        mentor= UnassignedUser.getUnassignedUser(nameMentors,surNameMentors,emailMentors,passwordMentors);
    }
    @BeforeClass
    public void precondition() throws IOException {
        editMentor= AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .inputSearchMentor("a")
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0).isAtPage(waitTime);
        editMentorURL=driver.getCurrentUrl();

    }
    @Test
    public void verifyInputFields(){
        SoftAssert softAssert = new SoftAssert();
        editMentor.editName(newNameOfMentors)
                .editSurname(newSurNameOfMentors)
                .editEmail(newEmailOfMentors)
                .saveMentor();
        softAssert.assertAll();
    }
    @Test
    public void verifyNewFirstName(){
        driver.get(editMentorURL);
        String actualResult=editMentor.getFirstName();
        String expectResult=newNameOfMentors;
        Assert.assertEquals(actualResult,expectResult);
    }
    @Test
    public void verifyNewLastName(){
        driver.get(editMentorURL);
        String actualResult=editMentor.getLastName();
        String expectResult=newSurNameOfMentors;
        Assert.assertEquals(actualResult,expectResult);
    }
    @Test
    public void verifyNewEmail(){
        driver.get(editMentorURL);
        String actualResult=editMentor.getEmail();
        String expectResult=newEmailOfMentors;
        Assert.assertEquals(actualResult,expectResult);
    }
}

