package api.mentors;


import api.base.AdminRequests;
import api.entities.groups.Group;
import api.entities.mentors.Mentor;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.OK;
import static api.APIConstants.HEADERS;
import static org.hamcrest.core.IsEqual.equalTo;

public class Mentors_verifyEditMentor_asAdmin_Test_Success {
    User user;
    User newMentor;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi = new AccountsServiceApi();
    MentorsServiceApi mentorsServiceApi;
    Group group = Group.getGroupObject(accountsServiceApi);
    Integer[] groupsId;
    Integer[] courseId;
    Mentor mentor;


    public Mentors_verifyEditMentor_asAdmin_Test_Success() throws IOException {
        groupsId = new Integer[]{group.getId()};
        courseId = new Integer[]{group.getCourseId()};
        user = User.getUserWithRandomValues();
        newMentor = User.getUserWithRandomValues();
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentor = mentorsServiceApi.postAssignMentor(registeredUser.getId()).as(Mentor.class);
        mentor
                .setMentorFirstName(newMentor.getFirstName())
                .setMentorLastName(newMentor.getLastName())
                .setMentorEmail(newMentor.getEmail())
                .setStudentGroupsIds(groupsId)
                .setCourseIds(courseId);
    }

    @Test
    public void verifyEditMentor() throws JsonProcessingException {
        mentorsServiceApi.editMentor(mentor)
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body("id", equalTo(mentor.getId()))
                .body("firstName", equalTo(mentor.getFirstName()))
                .body("lastName", equalTo(mentor.getLastName()))
                .body("email", equalTo(mentor.getEmail()))
                .extract()
                .as(RegisteredUser.class);
    }

    @AfterClass
    public void tearDawn() {
        mentorsServiceApi.deleteMentor(mentor.getId());
    }

}
