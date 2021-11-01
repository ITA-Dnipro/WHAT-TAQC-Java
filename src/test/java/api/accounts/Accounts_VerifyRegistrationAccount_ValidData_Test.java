package api.accounts;

import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.apache.commons.compress.archivers.ar.ArArchiveEntry.HEADER;
import static org.hamcrest.core.IsEqual.equalTo;

public class Accounts_VerifyRegistrationAccount_ValidData_Test {

    private AccountsServiceApi accountsServiceApi;
    private User user;
    private static Integer UNASSIGNED_USER_ROLE_ID = 0;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        user = User.getUserWithRandomValues();
    }

    @Test
    public void verifyRegistrationAccount() throws JsonProcessingException {
        accountsServiceApi.registrationAccount(user)
                .then()
                .assertThat()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .body("email", equalTo(user.getEmail()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("role", equalTo(UNASSIGNED_USER_ROLE_ID))
                .body("isActive", equalTo(true));
    }
}
