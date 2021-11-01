package api.accounts;

import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static api.APIConstants.HEADERS;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class Accounts_VerifyUserWithRoleCanSignIn_Test {

    protected AccountsServiceApi accountsServiceApi;
    protected RegisteredUser student;
    private static Integer STUDENT_ROLE_ID = 1;


    @BeforeClass
    public void setUp() throws IOException {
        User unassignedUser = User.getUserWithRandomValues();
        accountsServiceApi = new AccountsServiceApi();

        RegisteredUser registeredUser = accountsServiceApi
                .registrationAccount(unassignedUser)
                .as(RegisteredUser.class);

        student = AccountsServiceApi.getStudent(registeredUser);
        student.setPassword(unassignedUser.getPassword());
    }

    @Test
    public void verifyUserWithRoleCanSignIn() throws JsonProcessingException {
        accountsServiceApi.Auth(student)
                .then()
                .assertThat()
                .statusCode(200)
                .headers(HEADERS)
                .body("first_name", equalTo(student.getFirstName()))
                .body("last_name", equalTo(student.getLastName()))
                .body("role",equalTo(STUDENT_ROLE_ID));
    }
}
