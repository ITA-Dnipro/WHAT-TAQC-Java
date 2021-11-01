package secretarys.APIsecretaryTest;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.SecretaryServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.Matchers.containsString;


public class Secretaries_VerifyDeleteSecretary_SuccessfullyDisabled {
    User user;
    RegisteredUser registeredUser;
    RegisteredUser registeredSecretary;
    AccountsServiceApi accountsServiceApi;
    SecretaryServiceApi secretaryServiceApi;

    public Secretaries_VerifyDeleteSecretary_SuccessfullyDisabled() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        secretaryServiceApi = new SecretaryServiceApi(new AdminRequests());
        registeredSecretary = secretaryServiceApi.postAssignSecretary(registeredUser.getId()).as(RegisteredUser.class);

    }

    @Test
    public void VerifyDeleteSecretary_SuccessfullyDisabled() throws JsonProcessingException {
        Response deleteSecretaryResponse = secretaryServiceApi.deleteSecretary(registeredSecretary.getId());
       

        deleteSecretaryResponse
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body(containsString("true"));

    }
}
