package api.accounts;

import api.entities.users.RegisteredUser;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.HEADERS;
import static org.hamcrest.core.IsEqual.equalTo;

public class Accounts_VerifyUserWithStudentMentorSecretaryRoleCanSignIn_Test {

    protected AccountsServiceApi accountsServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        accountsServiceApi = new AccountsServiceApi();
    }

    @Test(dataProvider = "singIn", dataProviderClass = DataProviderAccounts.class)
    public void singInData(RegisteredUser user, Integer roleId, String roleName) throws JsonProcessingException {
        RegisteredUser userFromResponse = accountsServiceApi.Auth(user)
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .headers(HEADERS)
                .body("first_name", equalTo(user.getFirstName()))
                .body("last_name", equalTo(user.getLastName()))
                .body("role", equalTo(roleId))
                .extract()
                .as(RegisteredUser.class);

        Assert.assertTrue(userFromResponse.getRoleList().containsKey(roleName));
    }
}
