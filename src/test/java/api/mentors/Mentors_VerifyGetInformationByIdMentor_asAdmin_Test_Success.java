package api.mentors;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class Mentors_VerifyGetInformationByIdMentor_asAdmin_Test_Success {

    User user;
    RegisteredUser registeredUser;
    RegisteredUser mentor;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyGetInformationByIdMentor_asAdmin_Test_Success()  {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentor= mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }

    @Test
    public void verifyGetInformationByIdMentors() {

        Response mentorsById=mentorsServiceApi.getMentorsById(mentor.getId());
        mentorsById.as(RegisteredUser.class);
        mentorsById
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body("id",equalTo(mentor.getId()))
                .body("email", equalTo(mentor.getEmail()))
                .body("firstName", equalTo(mentor.getFirstName()))
                .body("lastName", equalTo(mentor.getLastName()));
    }
}
