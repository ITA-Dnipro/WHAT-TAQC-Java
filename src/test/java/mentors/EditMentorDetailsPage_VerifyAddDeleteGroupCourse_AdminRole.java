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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditMentorDetailsPage_VerifyAddDeleteGroupCourse_AdminRole extends BaseTest {
    UnassignedUser mentor;
    EditMentorsDetailsPage editMentorsPage;

    public EditMentorDetailsPage_VerifyAddDeleteGroupCourse_AdminRole() {
        mentor= UnassignedUser.getUnassignedUser();
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
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0)
                .isAtPage(waitTime)
                .choseGroup(0)
                .addGroup()
                .choseCourse(0)
                .addCourse()
                .saveMentor()
                .isAtPage(waitTime)
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0)
                .isAtPage(waitTime);
    }
    @Test(description = "DP213-159")
    public void verifyAddMentorFunction(){
        List<String>emptyList=new ArrayList<>();
        List<String>listGroupCard= Arrays.asList(editMentorsPage.getValueOfGroupCard(0));
        List<String>listCourseCard=Arrays.asList(editMentorsPage.getValueOfCourseCard(0));
        editMentorsPage
                .deleteGroup(0)
                .deleteCourse(0)
                .verifyListOfGroupsCard(emptyList)
                .verifyListOfCourseCard(emptyList)
                .saveMentor()
                .isAtPage(waitTime)
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0)
                .choseGroup(0)
                .addGroup()
                .verifyListOfGroupsCard(listGroupCard)
                .choseCourse(0)
                .addCourse()
                .verifyListOfCourseCard(listCourseCard)
                .saveMentor()
                .isAtPage(waitTime)
                .inputSearchMentor(mentor.getFirstName()+" "+mentor.getLastName())
                .editMentors(0)
                .verifyListOfGroupsCard(listGroupCard)
                .verifyListOfCourseCard(listCourseCard)
                .assertAll();
    }

}
