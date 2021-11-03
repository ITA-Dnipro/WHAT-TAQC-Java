package api.accounts;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static api.APIConstants.EMPTY_STRING;
import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class Accounts_VerifyRegistrationAccount_ValidData_Test {

    private AccountsServiceApi accountsServiceApi;
    private AccountsServiceApi adminRequests;
    private User user;
    private static Integer UNASSIGNED_USER_ROLE_ID = 0;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
        adminRequests = new AccountsServiceApi(new AdminRequests());
        user = User.getUserWithRandomValues();
    }

    @Test
    public void verifyRegistrationAccount() throws JsonProcessingException {
        RegisteredUser registeredUser = accountsServiceApi.registrationAccount(user)
                .then()
                .assertThat()
                .log().all()
                .statusCode(OK)
                .headers(HEADERS)
                .body("email", equalTo(user.getEmail()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("role", equalTo(UNASSIGNED_USER_ROLE_ID))
                .body("isActive", equalTo(true))
                .extract()
                .as(RegisteredUser.class);

        List<RegisteredUser> activeStudentsList = adminRequests.getAllRegisteredAccounts()
                .jsonPath()
                .getList(EMPTY_STRING, RegisteredUser.class);
        Assert.assertTrue(activeStudentsList.contains(registeredUser));
    }
}
