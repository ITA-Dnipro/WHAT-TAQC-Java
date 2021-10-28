package api.accounts;

import api.base.AdminRequests;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Accounts_VerifyCantRegistrationAccountWithInExistingEmail_Test {

    protected AccountsServiceApi accountsServiceApi;
    protected User user;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi(new AdminRequests());
        user = User.getUserWithRandomValues();
        User[] users = accountsServiceApi.getAllRegisteredAccounts()
                .then()
                .statusCode(200)
                .extract()
                .as(User[].class);
        user.setEmail(users[0].getEmail());
    }

    @Test
    public void verifyCantRegistrationAccountWithExistingEmail() throws JsonProcessingException {
        accountsServiceApi.registrationAccount(user)
                .then()
                .assertThat()
                .statusCode(409);
    }
}
