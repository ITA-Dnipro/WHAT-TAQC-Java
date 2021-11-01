package api.mentors;

import api.base.BaseRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.UNAUTHORIZED;

public class Mentors_VerifyAssignMentor_asUnauthorized_Test_Unauthorized {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyAssignMentor_asUnauthorized_Test_Unauthorized() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new BaseRequests());
    }

    @Test
    public void verifyAssignMentor() {
        Response mentor = mentorsServiceApi.postAssignMentor(registeredUser.getId());
        mentor
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED);
    }
}
