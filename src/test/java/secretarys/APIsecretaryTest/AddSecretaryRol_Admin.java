package secretarys.APIsecretaryTest;

import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class AddSecretaryRol_Admin {

    private AccountsServiceApi accountsServiceApi;
    private User user;

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
                .statusCode(200)
                .body("email", equalTo(user.getEmail()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("role", equalTo(0))
                .body("isActive", equalTo(true));
    }
}
