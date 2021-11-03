package api.accounts;

import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.BAD_REQUEST;

public class Accounts_VerifyRegistrationAccount_InvalidData_Test {

    private AccountsServiceApi accountsServiceApi;
    private static Integer UNASSIGNED_USER_ROLE_ID = 0;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
    }

    @Test(dataProvider = "registrationInvalidData", dataProviderClass = DataProviderAccounts.class)
    public void verifyRegistrationAccount(User user) throws JsonProcessingException {
        accountsServiceApi.registrationAccount(user)
                .then()
                .assertThat()
                .log().all()
                .statusCode(BAD_REQUEST);
    }
}
