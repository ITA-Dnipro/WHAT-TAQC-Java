package api.accounts;

import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class Accounts_VerifyUserWithRoleCanSignIn_Test {

    protected AccountsServiceApi accountsServiceApi;
    protected RegisteredUser student;

    @BeforeClass
    public void setUp() throws IOException {
        User unassignedUser = User.getUserWithRandomValues();
        accountsServiceApi = new AccountsServiceApi();

        RegisteredUser registeredUser = accountsServiceApi
                .registrationAccount(unassignedUser)
                .as(RegisteredUser.class);

        student = AccountsServiceApi.assignRoleStudent(registeredUser);
        student.setPassword(unassignedUser.getPassword());
    }

    @Test
    public void verifyUserWithRoleCanSignIn() throws JsonProcessingException {
        accountsServiceApi.Auth(student)
                .then()
                .assertThat()
                .statusCode(200)
                .body("first_name", equalTo(student.getFirstName()))
                .body("last_name", equalTo(student.getLastName()))
                .body("role", equalTo(student.getRole()))
                .body("id", equalTo(student.getId()));
    }
}
