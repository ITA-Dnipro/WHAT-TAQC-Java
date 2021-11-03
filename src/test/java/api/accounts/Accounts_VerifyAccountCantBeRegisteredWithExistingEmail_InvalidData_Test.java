package api.accounts;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.AccountEndpoints.EMAIL_EXISTED_MESSAGE;
import static api.APIConstants.StatusCodes.NO_RIGHTS;

public class Accounts_VerifyAccountCantBeRegisteredWithExistingEmail_InvalidData_Test {

    protected AccountsServiceApi accountsServiceApi;
    protected User user;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi(new AdminRequests());
        user = User.getUserWithRandomValues();

        User[] users = accountsServiceApi.getAllRegisteredAccounts()
                .then()
                .extract()
                .as(User[].class);
        user.setEmail(users[0].getEmail());
    }

    @Test
    public void verifyCantRegistrationAccountWithExistingEmail() throws JsonProcessingException {
        ResponseError responseError =
                accountsServiceApi.registrationAccount(user)
                        .then()
                        .assertThat()
                        .log().all()
                        .statusCode(NO_RIGHTS)
                        .extract()
                        .as(ResponseError.class);
        Assert.assertEquals(responseError.getError().getMessage(), EMAIL_EXISTED_MESSAGE);

    }
}
