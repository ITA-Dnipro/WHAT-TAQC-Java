package secretarys.APIsecretaryTest;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.SecretaryServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.BAD_REQUEST;
import static org.hamcrest.core.IsEqual.equalTo;

public class Secretary_VerifyAssignSecretaryRole_ForbiddenError {
    User user;
    RegisteredUser registeredUser;
    RegisteredUser registeredSecretary;
    AccountsServiceApi accountsServiceApi;
    SecretaryServiceApi secretaryServiceApi;

    public Secretary_VerifyAssignSecretaryRole_ForbiddenError() {
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
    public void VerifyAssignSecretaryRole_ForbiddenError() {
        secretaryServiceApi.postAssignSecretary(registeredUser.getId());

        Response test = secretaryServiceApi.postAssignSecretary(registeredUser.getId());


        test.as(ResponseError.class);
        test
                .then()
                .assertThat()
                .statusCode(BAD_REQUEST)
                .body("error.message", equalTo("This account already assigned."))
                .body("error.code", equalTo(0));
    }
}
