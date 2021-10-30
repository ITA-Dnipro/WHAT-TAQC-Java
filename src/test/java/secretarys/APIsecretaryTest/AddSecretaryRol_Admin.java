package secretarys.APIsecretaryTest;

import api.base.AdminRequests;
import api.entities.error.ResponseError;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.MentorsServiceApi;
import api.services.SecretaryServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.APIConstants.StatusCodes.BAD_REQUEST;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddSecretaryRol_Admin {

    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    SecretaryServiceApi secretaryServiceApi;

    public AddSecretaryRol_Admin()  {
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
    public void test() {
        secretaryServiceApi.postAssignSecretary(registeredUser.getId());
    Response test = secretaryServiceApi.postAssignSecretary(registeredUser.getId());
               test.as(ResponseError.class);
        test
                .then()
                .assertThat()
                .statusCode(BAD_REQUEST)
                .body("error.message",equalTo("This account already assigned."))
                .body("error.code",equalTo(0));
    }
}
