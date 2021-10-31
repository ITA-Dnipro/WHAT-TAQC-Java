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

public class Mentors_VerifyGetActiveMentors_asAdmin_Test_Success {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyGetActiveMentors_asAdmin_Test_Success() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentorsServiceApi.postAssignMentor(registeredUser.getId());
    }

    @Test
    public void verifyGetActiveMentors() {

        Response activeMentors = mentorsServiceApi.getActiveMentors();
        activeMentors.as(RegisteredUser[].class);
        activeMentors
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS);

    }
}
