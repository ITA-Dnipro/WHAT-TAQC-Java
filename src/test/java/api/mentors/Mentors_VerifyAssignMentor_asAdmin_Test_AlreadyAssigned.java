package api.mentors;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class Mentors_VerifyAssignMentor_asAdmin_Test_AlreadyAssigned {
        User user;
        RegisteredUser registeredUser;
        AccountsServiceApi accountsServiceApi;
        MentorsServiceApi mentorsServiceApi;

        public Mentors_VerifyAssignMentor_asAdmin_Test_AlreadyAssigned()  {
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
        public void verifyAssignMentor() {
            mentorsServiceApi.postAssignMentor(registeredUser.getId());
            Response mentor = mentorsServiceApi.postAssignMentor(registeredUser.getId());
            mentor.as(ResponseError.class);
            mentor
                    .then()
                    .assertThat()
                    .statusCode(BAD_REQUEST)
                    .body("error.message",equalTo("This account already assigned."))
                    .body("error.code",equalTo(0));
        }
}
