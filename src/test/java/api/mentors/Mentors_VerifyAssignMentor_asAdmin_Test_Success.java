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

public class Mentors_VerifyAssignMentor_asAdmin_Test_Success {

    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyAssignMentor_asAdmin_Test_Success()  {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
    }

    @Test
    public void test() {

        Response test = mentorsServiceApi.postAssignMentor(registeredUser.getId());
        test.as(RegisteredUser.class);
        test
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body("email", equalTo(registeredUser.getEmail()))
                .body("firstName", equalTo(registeredUser.getFirstName()))
                .body("lastName", equalTo(registeredUser.getLastName()));
    }
}
