package api.mentors;

import api.base.AdminRequests;
import api.base.BaseRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.ACCOUNT_NOT_FOUND;
import static api.APIConstants.StatusCodes.UNAUTHORIZED;

public class Mentors_VerifyGetInformationByIdMentor_asAdmin_Test_NotFound {



    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    private final static Integer notFoundId = -1;

    public Mentors_VerifyGetInformationByIdMentor_asAdmin_Test_NotFound() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());

    }

    @BeforeClass
    public void setUp() throws IOException {

    }
    @Test
    public void verifyGetInformationByIdMentors() {
        mentorsServiceApi
                 .getMentorsById(notFoundId)
                .then()
                .assertThat()
                .statusCode(ACCOUNT_NOT_FOUND);
    }
}
