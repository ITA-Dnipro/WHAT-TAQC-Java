package secretarys.APIsecretaryTest;

import api.base.AdminRequests;
import api.entities.secretararys.Secretary;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.SecretaryServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class Secretaries_VerifyUpdatesExact_UpdatedSecretary {

    User user;
    RegisteredUser registeredUser;
    AccountsServiceApi accountsServiceApi;
    SecretaryServiceApi secretaryServiceApi;

    public Secretaries_VerifyUpdatesExact_UpdatedSecretary()  {
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
    public void VerifyUpdatesExact_UpdatedSecretary() throws JsonProcessingException {
        Response secretaryResponse = secretaryServiceApi.postAssignSecretary(registeredUser.getId());
        Secretary secretary = secretaryResponse.as(Secretary.class);
        secretary.setFirstName("Vika");

        Response test = secretaryServiceApi.updateSecretary(secretary);

                test
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body("email", equalTo(registeredUser.getEmail()))
                .body("firstName", equalTo("Vika"))
                .body("lastName", equalTo(registeredUser.getLastName()));
    }
}



