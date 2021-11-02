package api.mentors;

import api.base.BaseRequests;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.UNAUTHORIZED;

public class Mentors_VerifyGetActiveMentors_asUnauthorized_Test_Unauthorized {

    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;

    public Mentors_VerifyGetActiveMentors_asUnauthorized_Test_Unauthorized() {
        accountsServiceApi = new AccountsServiceApi();
    }

    @BeforeClass
    public void setUp() throws IOException {
        mentorsServiceApi = new MentorsServiceApi(new BaseRequests());
    }

    @Test
    public void verifyGetActiveMentors() {
        mentorsServiceApi
                .getActiveMentors()
                .then()
                .assertThat()
                .statusCode(UNAUTHORIZED);
    }
}
