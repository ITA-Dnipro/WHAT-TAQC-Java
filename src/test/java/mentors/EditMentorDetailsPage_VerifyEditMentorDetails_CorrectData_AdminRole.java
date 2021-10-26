package mentors;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

public class EditMentorDetailsPage_VerifyEditMentorDetails_CorrectData_AdminRole extends BaseTest {

    String newNameOfMentors;
    String newSurNameOfMentors;
    String newEmailOfMentors;
    UnassignedUser mentor;
    EditMentorsDetailsPage editMentor;
    String editMentorURL;

    public EditMentorDetailsPage_VerifyEditMentorDetails_CorrectData_AdminRole() {
        mentor= UnassignedUser.getUnassignedUser();
        newNameOfMentors=mentor.getFirstName()+"new";
        newSurNameOfMentors=mentor.getLastName()+"new";
        newEmailOfMentors=mentor.getEmail()+"new";
    }
    @BeforeClass
    public void setUp() throws IOException {
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
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0)
                .isAtPage(waitTime);
        editMentorURL=driver.getCurrentUrl();
    }
    @Test(description = "DP213-150")
    public void VerifyEditMentorDetails_CorrectData(){

        editMentor.inputFirstName(newNameOfMentors)
                .inputSurname(newSurNameOfMentors)
                .verifyInputSurName(newSurNameOfMentors)
                .inputEmail(newEmailOfMentors)
                .verifyInputEmail(newEmailOfMentors)
                .saveMentor()
                .isAtPage(waitTime)
                .inputSearchMentor(newNameOfMentors+" "+newSurNameOfMentors)
                .verifyInputSearchField(newNameOfMentors+" "+newSurNameOfMentors)
                .editMentors(0)
                .isAtPage(waitTime)
                .verifyInputName(newNameOfMentors)
                .verifyInputSurName(newSurNameOfMentors)
                .verifyInputEmail(newEmailOfMentors)
                .assertAll();
    }
}

