package api.students;

import api.base.AdminRequests;
import api.entities.users.RegisteredUser;
import api.entities.users.User;
import api.services.AccountsServiceApi;
import api.services.StudentServiceApi;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static api.APIConstants.EMPTY_STRING;
import static api.APIConstants.HEADERS;
import static api.APIConstants.StatusCodes.OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class Students_VerifyRoleStudentCanBeAssignToUnassignedUser_Admin_Test {
    protected User user;
    protected RegisteredUser registeredUser;
    protected AccountsServiceApi accountsServiceApi;
    protected StudentServiceApi studentServiceApi;

    @BeforeClass
    public void setUp() throws IOException {
        user = User.getUserWithRandomValues();
        accountsServiceApi = new AccountsServiceApi();
        studentServiceApi = new StudentServiceApi(new AdminRequests());
        registeredUser = accountsServiceApi
                .registrationAccount(user)
                .as(RegisteredUser.class);
    }

    @Test
    public void verifyRoleStudentCanBeAssignToUnassignedUser() {
        studentServiceApi.postAssignStudent(registeredUser.getId())
                .then()
                .assertThat()
                .statusCode(OK)
                .headers(HEADERS)
                .body("email", equalTo(user.getEmail()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()));
        List<RegisteredUser> activeStudentsList = studentServiceApi.getGetAllActiveStudents()
                .jsonPath()
                .getList(EMPTY_STRING, RegisteredUser.class);
        Assert.assertTrue(activeStudentsList.contains(registeredUser));
    }
}
