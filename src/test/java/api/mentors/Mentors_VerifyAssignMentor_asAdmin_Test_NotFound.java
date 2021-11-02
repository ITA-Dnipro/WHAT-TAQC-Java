package api.mentors;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.APIConstants.AccountEndpoints.NOT_FOUND_MESSAGE;
import static api.APIConstants.StatusCodes.*;
import static org.hamcrest.core.IsEqual.equalTo;

import java.io.IOException;

public class Mentors_VerifyAssignMentor_asAdmin_Test_NotFound {
    AccountsServiceApi accountsServiceApi;
    MentorsServiceApi mentorsServiceApi;
    private final static Integer notFoundId = -1;

    public Mentors_VerifyAssignMentor_asAdmin_Test_NotFound() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        mentorsServiceApi = new MentorsServiceApi(new AdminRequests());
    }

    @Test
    public void verifyAssignMentor() {
        Response mentor =mentorsServiceApi.postAssignMentor(notFoundId);
        mentor.as(ResponseError.class);
        mentor.then()
                .assertThat()
                .statusCode(ACCOUNT_NOT_FOUND)
                .body("error.message",equalTo(NOT_FOUND_MESSAGE))
                .extract()
                .as(ResponseError.class);
    }
}
