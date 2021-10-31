package api.mentors;

import api.base.AdminRequests;
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

public class Mentors_VerifyGetInformationByIdMentor_asUnauthorized_Test_Unauthorized {

    User user;
    RegisteredUser registeredUser;
    RegisteredUser mentor;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    MentorsServiceApi mentorsServiceApiUnauthorized;

    public Mentors_VerifyGetInformationByIdMentor_asUnauthorized_Test_Unauthorized() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentorsServiceApiUnauthorized =new MentorsServiceApi(new BaseRequests());
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);

        mentor= mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .as(RegisteredUser.class);
    }
    @Test
    public void verifyEditMentors() {
         mentorsServiceApiUnauthorized
                 .getMentorsById(mentor.getId())
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED);
    }
}
