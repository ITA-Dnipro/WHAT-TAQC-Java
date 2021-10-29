package api.mentors;

import api.base.StudentRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.FORBIDDEN;

public class Mentors_VerifyAssignMentor_asStudent_Test_Forbiddens {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyAssignMentor_asStudent_Test_Forbiddens()  {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new StudentRequests());
    }

    @Test
    public void test() {
        Response test = mentorsServiceApi.postAssignMentor(registeredUser.getId());
        test
                .then()
                .assertThat()
                .statusCode(FORBIDDEN);
    }
}
