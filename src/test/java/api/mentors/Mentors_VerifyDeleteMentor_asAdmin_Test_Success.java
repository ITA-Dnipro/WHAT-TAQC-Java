package api.mentors;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.OK;
import static api.APIConstants.HEADERS;

public class Mentors_VerifyDeleteMentor_asAdmin_Test_Success {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    RegisteredUser mentor;

    public Mentors_VerifyDeleteMentor_asAdmin_Test_Success() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentor=mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }

    @Test
    public void verifyDeleteMentor() {
        Response test = mentorsServiceApi.deleteMentor(mentor.getId());
        test
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS);
        Assert.assertTrue(test.as(Boolean.class));
    }

}
