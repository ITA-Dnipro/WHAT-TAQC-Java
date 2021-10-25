package mentors;

import base.BaseTest;
import constants.Endpoints;
import constants.PathsToFiles;
import mentors.data.InvalidData;
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

public class EditMentorsDetailsPage_VerifyEditMentors_IncorrectData_AdminRole extends BaseTest {
    InvalidData[] data;
    UnassignedUser mentor;
   EditMentorsDetailsPage editMentorsPage;

    public EditMentorsDetailsPage_VerifyEditMentors_IncorrectData_AdminRole() throws IOException {
        mentor= UnassignedUser.getUnassignedUser();
        data=InvalidData.getData(PathsToFiles.Mentors.EDIT_MENTOR_ERRORS);
    }

    @BeforeClass
    public void setUp() throws IOException {

        editMentorsPage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(mentor)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(mentor.getEmail(), UnassignedRole.MENTOR)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.MENTORS, MentorsTablePage.class)
                .inputSearchMentor(mentor.getFirstName() + " " + mentor.getLastName())
                .editMentors(0)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "errors")
    public Object[][] provide() {
        Object[][] list = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            list[i][0] = data[i];
        }
        return list;
    }

    @Test(description = "DP213-170", dataProvider = "errors")
    public void verifyEditMentors_IncorrectData(InvalidData errors) {

        editMentorsPage
                .isAtPage(waitTime)
                .clearFields()
                .inputFirstName(errors.getName())
                .verifyInputName(errors.getName())
                .loseFocus()
                .verifyFirstNameErrors(errors.getErrorName())
                .inputSurname(errors.getLast_name())
                .verifyInputSurName(errors.getLast_name())
                .verifyLastNameErrors(errors.getErrorSurname())
                .inputEmail(errors.getEmail())
                .verifyInputEmail(errors.getEmail())
                .verifyEmailErrors(errors.getErrorEmail())
                .assertAll();
    }
}
