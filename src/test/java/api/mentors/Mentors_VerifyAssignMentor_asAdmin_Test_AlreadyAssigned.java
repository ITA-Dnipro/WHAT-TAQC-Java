package api.mentors;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.AccountEndpoints.BAD_REQUEST_MESSAGE;
import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.BAD_REQUEST;
import static org.hamcrest.core.IsEqual.equalTo;

public class Mentors_VerifyAssignMentor_asAdmin_Test_AlreadyAssigned {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    RegisteredUser mentor;

    public Mentors_VerifyAssignMentor_asAdmin_Test_AlreadyAssigned() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
        mentor = mentorsServiceApi.postAssignMentor(registeredUser.getId()).as(RegisteredUser.class);
    }

    @Test
    public void verifyAssignMentor() {
        mentorsServiceApi
                .postAssignMentor(registeredUser.getId())
                .then()
                .assertThat()
                .statusCode(BAD_REQUEST)
                .body("error.message", equalTo(BAD_REQUEST_MESSAGE))
                .extract()
                .as(ResponseError.class);
    }

    @AfterClass
    public void tearDown() {
        mentorsServiceApi.deleteMentor(mentor.getId());
    }
}
