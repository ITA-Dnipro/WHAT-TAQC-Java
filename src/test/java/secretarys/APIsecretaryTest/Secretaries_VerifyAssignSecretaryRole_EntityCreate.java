package secretarys.APIsecretaryTest;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.SecretaryServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class Secretaries_VerifyAssignSecretaryRole_EntityCreate {
    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    SecretaryServiceApi secretaryServiceApi;

    public Secretaries_VerifyAssignSecretaryRole_EntityCreate() {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @BeforeClass
    public void setUp() throws IOException {
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
        secretaryServiceApi = new SecretaryServiceApi(new AdminRequests());
    }

    @Test
    public void VerifyAssignSecretaryRole_EntityCreate() {
        Response test = secretaryServiceApi.postAssignSecretary(registeredUser.getId());

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
